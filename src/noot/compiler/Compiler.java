/*
 * @author Thijs Scheepers <thijs@label305.com>
 * Copyright (c) 2013 Thijs Scheepers.
 *
 * This source is subject to the BSD License.
 * Please see the LICENSE file for more information.
 * All other rights reserved.
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 * 
 */

package noot.compiler;

import java.io.*;

import TAM.*;

import noot.antlr.Checker;
import noot.antlr.Generator;
import noot.antlr.NootLexer;
import noot.antlr.NootParser;
import noot.ast.DOTNodeAdaptor;
import noot.ast.NodeAdaptor;
import noot.exceptions.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

/**
 * The Class Compiler.
 */
public class Compiler {

	/**
	 * The verbose logging.
	 * 
	 * If true the compiler will log more detailed information.
	 */
	private boolean verboseLogging = false;

	/**
	 * Compile the input file
	 * 
	 * You should always enter a file with a .nt extention.
	 * This will automatically generate .as, .tam and optionally .dot
	 * files. With the .as you could examine the generated
	 * TAM instructions. The .dot is a visual representation
	 * of the AST. And the .tam is a file you can put into
	 * the TAM Interpreter. After compilation the program
	 * will automatically be executed if runAfterwards is true.
	 *
	 * @param inputFile the input file should have the .nt extention
	 * @param runAfterwards enter true if you want to run afterwards the program
	 * @param verboseLogging enter true if you want verbose logging
	 * @param generateASTVisualization enter true if you want an AST visualization to be generated as a .dot file
	 * @throws RecognitionException 
	 * @throws IOException 
	 */
	public void compile(String inputFile, boolean runAfterwards, boolean verboseLogging, boolean generateASTVisualization) throws RecognitionException, IOException
	{
		this.verboseLogging = verboseLogging;
		PrintStream standardPrintStream = System.out;

		if(!inputFile.endsWith(".nt"))
		{
			System.err.println("The input file should have the .nt extention");
			return;
		}

		// Because we know the file ends with the .nt extension these string methods can be used
		// to determine other filenames.
		String intermediateFile = inputFile.substring(0, inputFile.length()-3) + ".as";
		String DOTFile = inputFile.substring(0, inputFile.length()-3) + ".dot";
		String TAMFile = inputFile.substring(0, inputFile.length()-3) + ".tam";

		printForVerboseLogging("- Lexical analysis");

		FileInputStream fileInputStream = new FileInputStream(inputFile);
		NootLexer lexer = new NootLexer(new ANTLRInputStream(fileInputStream));

		printForVerboseLogging("- Parsing");

		NootParser parser = new NootParser(new CommonTokenStream(lexer));
		parser.setTreeAdaptor(new NodeAdaptor());
		CommonTree tree = (CommonTree) parser.program().getTree();

		printForVerboseLogging("- Contextual analysis");
		Checker checker = new Checker(new CommonTreeNodeStream(tree));
		checker.program();

		if(generateASTVisualization)
		{
			printForVerboseLogging("- Generating AST visualization (" + DOTFile + ")");

			DOTTreeGenerator gen = new DOTTreeGenerator();
			StringTemplate st = gen.toDOT(tree,new DOTNodeAdaptor());

			PrintStream DOTOut = new PrintStream(new File(DOTFile));
			DOTOut.println(st);
			DOTOut.close();
		}

		printForVerboseLogging("- Intermediate code generation (" + intermediateFile + ")");

		Generator generator = new Generator(new BufferedTreeNodeStream(tree));
		PrintStream writeIntermediateFile = new PrintStream(new File(intermediateFile));

		System.setOut(writeIntermediateFile);
		generator.program();
		System.setOut(standardPrintStream); 
		writeIntermediateFile.close();

		printForVerboseLogging("- Assemble to TAM (" + TAMFile + ")");

		InputStream readIntermediateFile = new FileInputStream(intermediateFile);
		OutputStream writeTAMFile = new FileOutputStream(TAMFile);

		Assembler.assemble(readIntermediateFile, writeTAMFile);
		readIntermediateFile.close();
		writeTAMFile.close();

		if(runAfterwards)
		{
			printForVerboseLogging("- Reading TAM");

			Interpreter.loadObjectProgram(TAMFile);

			printForVerboseLogging("- Execution");

			Interpreter.interpretProgram();

			if(verboseLogging)
			{
				printForVerboseLogging("- Execution Results");
				Interpreter.showStatus();
			}
			else
				Interpreter.showFailedStatus();
		}
	}

	/**
	 * Prints out if verbose logging is enabled.
	 *
	 * @param out the string to print to System.out
	 */
	public void printForVerboseLogging(String out)
	{
		if(verboseLogging) System.out.println(out);
	}

	/**
	 * The main method.
	 * 
	 * This method will create a compiler object and call it with all options enabled.
	 * The first entered argument will be the location of the file that should be compiled
	 * and executed.
	 * 
	 * In order for this program to work you should enter one argument linking to a .nt file
	 * that you whish to compile.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		Compiler c = new Compiler();
		boolean verboseLogging = true;

		if (args.length == 1)
		{
			try 
			{
				c.compile(args[0], true, verboseLogging, true);
			}
			catch (LexerParserException e)
			{
				System.err.println("** LEXER/PARSER ERROR **");
				System.err.println(e.getMessage());
			}
			catch (CheckerException e)
			{
				System.err.println("** CHECKER ERROR **");
				System.err.println(e.getMessage());
				System.err.println("Please resolve the issue and recompile.");
			}
			catch (GeneratorException e)
			{
				System.err.println("** GENERATOR ERROR **");
				System.err.println(e.getMessage());
				System.err.println("Please resolve the issue and recompile.");
			}
			catch (NootException e)
			{
				System.err.println("** COMPILE ERROR **");
				System.err.println(e.getMessage());
				System.err.println("Please resolve the issue and recompile.");
			}
			catch (RecognitionException e)
			{
				System.err.println("** UNEXPECTED COMPILE ERROR **");
				System.err.println(e.getMessage());
				System.err.println("Please resolve the issue and recompile.");

				if(verboseLogging) e.printStackTrace();
			}
			catch (IOException e)
			{
				System.err.println("** UNEXPECTED IO ERROR **");
				System.err.println(e.getMessage());

				if(verboseLogging) e.printStackTrace();
			}
		}
		else
		{
			System.err.println("Please enter a .nt file to compile.");
		}
	}

}
