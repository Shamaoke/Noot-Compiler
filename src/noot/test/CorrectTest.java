/**
 * @author Thijs Scheepers <thijs@label305.com>
 * Copyright (c) 2013 Thijs Scheepers. All Right Reserved.
 *
 * This source is subject to the BSD Licence.
 * Please see the LICENSE file for more information.
 * All other rights reserved.
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 */
package noot.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import noot.ast.DOTNodeAdaptor;
import noot.ast.NodeAdaptor;
import noot.compiler.Checker;
import noot.compiler.Generator;
import noot.compiler.NootLexer;
import noot.compiler.NootParser;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.stringtemplate.StringTemplate;
import org.junit.Test;

import TAM.Assembler;
import TAM.Interpreter;

/**
 * @author Thijs
 *
 */
public class CorrectTest {

	@Test
	public void testExpressions() {
		assertTrue(testFile("tests/expressions_correct.nt","true\ntrue\ntrue\ntrue\ntrue\ntrue\n",null));
	}
	
	@Test
	public void testCompoundExpressions() {
		assertTrue(testFile("tests/compound_expressions_correct.nt","true\n2\ntrue\ntrue\nfalse\nb\na\n",null));
	}
	
	@Test
	public void testAssignments() {
		assertTrue(testFile("tests/assignment_correct.nt","0\n0\ntrue\nz\n",null));
	}
	
	@Test
	public void testIfElse() {
		assertTrue(testFile("tests/if_else_correct.nt","2\n2\nb\na\n1\n",null));
	}
	
	@Test
	public void testWhile() {
		assertTrue(testFile("tests/while_correct.nt","2\n3\n4\n",null));
	}
	
	private boolean testFile(String inputFile, String output, String input)
	{
		
		if(!inputFile.endsWith(".nt"))
		{
			System.err.println("The input file should have the .nt extention");
			return false;
		}
		
		String intermediateFile = inputFile.substring(0, inputFile.length()-3) + ".as";
		String DOTFile = inputFile.substring(0, inputFile.length()-3) + ".dot";
		String outputFile = inputFile.substring(0, inputFile.length()-3) + ".tam";
		
		try {
			
			System.out.println("*** Testing "+inputFile+" ***");
			
			InputStream in = new FileInputStream(inputFile);
			NootLexer lexer = new NootLexer(new ANTLRInputStream(in));
			
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			NootParser parser = new NootParser(tokens);
			parser.setTreeAdaptor(new NodeAdaptor());

			NootParser.program_return result = parser.program();
			CommonTree tree = (CommonTree) result.getTree();

			CommonTreeNodeStream checkerNodes = new CommonTreeNodeStream(tree);
			Checker checker = new Checker(checkerNodes);
			checker.program();
			
			DOTTreeGenerator gen = new DOTTreeGenerator();
			
            StringTemplate st = gen.toDOT(tree,new DOTNodeAdaptor());
            
            File DOTf = new File(DOTFile);
        	PrintStream DOTOut = new PrintStream(DOTf);
        	DOTOut.println(st);
        	DOTOut.close();
                        	
			TreeNodeStream generatorNodes = new BufferedTreeNodeStream(tree);
        	Generator generator = new Generator(generatorNodes);
        	File f = new File(intermediateFile);
        	PrintStream intermediateOut = new PrintStream(f);
        	
        	PrintStream standardOut = System.out;
        	System.setOut(intermediateOut);
        	generator.program();
        	intermediateOut.close();
        	System.setOut(standardOut);  
        	
        	InputStream intermediateIn = new FileInputStream(intermediateFile);
            OutputStream out = new FileOutputStream(outputFile);

            Assembler.assemble(intermediateIn, out);
            intermediateIn.close();
            out.close();
            
            Interpreter.loadObjectProgram(outputFile);
            
            ByteArrayOutputStream resultOut = new ByteArrayOutputStream();
            PrintStream resultPrintOut = new PrintStream(resultOut);
            
            System.setOut(resultPrintOut);
            Interpreter.interpretProgram();
            
            resultPrintOut.close();
            resultOut.close();
            System.setOut(standardOut); 
            
            System.out.println("- Expected Result -");
            System.out.print(output);
            
            String resultString = new String(resultOut.toByteArray(), Charset.defaultCharset());
            
            System.out.println("- Result -");
            System.out.print(resultString);
            
            return output.equals(resultString);
            

		} catch (RecognitionException e) {
			//System.err.print("ERROR: recognition exception thrown by compiler: ");
			System.err.println(e.getMessage());
			e.printStackTrace();
			
			return false;
			
		} catch (Exception e) {
			//System.err.print("ERROR: uncaught exception thrown by compiler: ");
			System.err.println(e.getMessage());
			e.printStackTrace();
			
			return false;
		}

	}

}
