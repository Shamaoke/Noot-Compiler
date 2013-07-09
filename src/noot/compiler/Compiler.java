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

import noot.ast.DOTNodeAdaptor;
import noot.ast.NodeAdaptor;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class Compiler.
 */
public class Compiler {

	/** The verbose logging. */
	private boolean verboseLogging = false;

	/**
	 * Compile.
	 *
	 * @param inputFile the input file
	 * @param runAfterwards the run afterwards
	 * @param verboseLogging the verbose logging
	 * @param generateASTVisualization the generate ast visualization
	 * @return true, if successful
	 * @throws RecognitionException 
	 * @throws IOException 
	 */
	public boolean compile(String inputFile, boolean runAfterwards, boolean verboseLogging, boolean generateASTVisualization) throws RecognitionException, IOException
	{
		this.verboseLogging = verboseLogging;
		PrintStream standardPrintStream = System.out;

		if(!inputFile.endsWith(".nt"))
		{
			System.err.println("The input file should have the .nt extention");
			return false;
		}

		String intermediateFile = inputFile.substring(0, inputFile.length()-3) + ".as";
		String DOTFile = inputFile.substring(0, inputFile.length()-3) + ".dot";
		String TAMFile = inputFile.substring(0, inputFile.length()-3) + ".tam";

		printForVerboseLoging("- Lexical analysis");

		FileInputStream fileInputStream = new FileInputStream(inputFile);
		NootLexer lexer = new NootLexer(new ANTLRInputStream(fileInputStream));

		printForVerboseLoging("- Parsing");

		NootParser parser = new NootParser(new CommonTokenStream(lexer));
		parser.setTreeAdaptor(new NodeAdaptor());
		CommonTree tree = (CommonTree) parser.program().getTree();

		printForVerboseLoging("- Contextual analysis");
		Checker checker = new Checker(new CommonTreeNodeStream(tree));
		checker.program();

		if(generateASTVisualization)
		{
			printForVerboseLoging("- Generating AST visualization (" + DOTFile + ")");

			DOTTreeGenerator gen = new DOTTreeGenerator();
			StringTemplate st = gen.toDOT(tree,new DOTNodeAdaptor());

			PrintStream DOTOut = new PrintStream(new File(DOTFile));
			DOTOut.println(st);
			DOTOut.close();
		}

		printForVerboseLoging("- Intermediate code generation (" + intermediateFile + ")");

		Generator generator = new Generator(new BufferedTreeNodeStream(tree));
		PrintStream writeIntermediateFile = new PrintStream(new File(intermediateFile));

		System.setOut(writeIntermediateFile);
		generator.program();
		System.setOut(standardPrintStream); 
		writeIntermediateFile.close();

		printForVerboseLoging("- Assemble to TAM (" + TAMFile + ")");

		InputStream readIntermediateFile = new FileInputStream(intermediateFile);
		OutputStream writeTAMFile = new FileOutputStream(TAMFile);

		Assembler.assemble(readIntermediateFile, writeTAMFile);
		readIntermediateFile.close();
		writeTAMFile.close();

		if(runAfterwards)
		{
			printForVerboseLoging("- Reading TAM");

			Interpreter.loadObjectProgram(TAMFile);

			printForVerboseLoging("- Execution Test");

			Interpreter.interpretProgram();

			if(verboseLogging)
			{
				printForVerboseLoging("- Execution Results");
				Interpreter.showStatus();
			}
			else
			{
				Interpreter.showFailedStatus();
			}
		}

		return true;


	}

	/**
	 * Prints the for verbose loging.
	 *
	 * @param out the out
	 */
	public void printForVerboseLoging(String out)
	{
		if(verboseLogging) System.out.println(out);
	}

	/**
	 * The main method.
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
			catch (RecognitionException e)
			{
				System.err.println("** COMPILE ERROR **");
				System.err.println(e.getMessage());
				System.err.println("Please resolve the issue and recompile.");

				if(verboseLogging) e.printStackTrace();
			}
			catch (IOException e)
			{
				System.err.print("** IO ERROR **");
				System.err.println(e.getMessage());

				if(verboseLogging) e.printStackTrace();
			}
			catch (LexerParserException e)
			{
				System.err.print("** LEXER/PARSER ERROR **");
				System.err.println(e.getMessage());
			}
		}
		else
		{
			System.err.println("Please enter a .nt file to compile.");
		}
	}

}
