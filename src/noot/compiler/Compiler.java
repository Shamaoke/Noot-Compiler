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
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.stringtemplate.StringTemplate;

public class Compiler {

	private static String inputFile;
	private static String intermediateFile;
	private static String DOTFile;
	private static String outputFile;

	public static void parseOptions(String[] args)
	{
		if (args.length != 1)
		{
			System.err.println("There should an argument for the Noot file to compile");
			System.exit(1);
		}
		
		inputFile = args[0];
		
		if(!inputFile.endsWith(".nt"))
		{
			System.err.println("The input file should have the .nt extention");
			System.exit(1);
		}
		
		intermediateFile = inputFile.substring(0, inputFile.length()-3) + ".as";
		DOTFile = inputFile.substring(0, inputFile.length()-3) + ".dot";
		outputFile = inputFile.substring(0, inputFile.length()-3) + ".tam";

	}

	public static void main(String[] args) {
		parseOptions(args);

		try {
			
			System.out.println("- Lexical analysis");
			
			InputStream in = inputFile == null ? System.in : new FileInputStream(inputFile);
			NootLexer lexer = new NootLexer(new ANTLRInputStream(in));
			
			System.out.println("- Parsing");
			
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			NootParser parser = new NootParser(tokens);
			parser.setTreeAdaptor(new NodeAdaptor());

			NootParser.program_return result = parser.program();
			CommonTree tree = (CommonTree) result.getTree();
			
			// Printing the AST
			System.out.println(tree.toStringTree());
			
			System.out.println("- Contextual analysis");

			CommonTreeNodeStream checkerNodes = new CommonTreeNodeStream(tree);
			Checker checker = new Checker(checkerNodes);
			checker.program();
			
			// Printing the AST
			System.out.println(tree.toStringTree());
			
			System.out.println("- Generating AST visualization");
			
			DOTTreeGenerator gen = new DOTTreeGenerator();
			
            StringTemplate st = gen.toDOT(tree,new DOTNodeAdaptor());
            
            File DOTf = new File(DOTFile);
        	PrintStream DOTOut = new PrintStream(DOTf);
        	DOTOut.println(st);
        	DOTOut.close();
			
			System.out.println("- Intermediate code generation");
                        	
			TreeNodeStream generatorNodes = new BufferedTreeNodeStream(tree);
        	Generator generator = new Generator(generatorNodes);
        	File f = new File(intermediateFile);
        	PrintStream intermediateOut = new PrintStream(f);
        	
        	PrintStream standardOut = System.out;
        	System.setOut(intermediateOut);
        	generator.program();
        	intermediateOut.close();
        	System.setOut(standardOut);  
        	
        	System.out.println("- Assemble intermediate code");
        	
        	InputStream intermediateIn = new FileInputStream(intermediateFile);
            OutputStream out = new FileOutputStream(outputFile);

            Assembler.assemble(intermediateIn, out);
            intermediateIn.close();
            out.close();
            
            System.out.println("- Read Assembly");
            
            Interpreter.loadObjectProgram(outputFile);
            
            System.out.println("- Execution Test");
            
            Interpreter.interpretProgram();
            
            System.out.println("- Execution Results");
            
            Interpreter.showStatus();

		} catch (RecognitionException e) {
			System.err.print("ERROR: recognition exception thrown by compiler: ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.print("ERROR: uncaught exception thrown by compiler: ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
