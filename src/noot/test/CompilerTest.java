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
package noot.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

import noot.compiler.Compiler;

import org.junit.Test;

/**
 * The Class CompilerTest.
 *
 * We can use JUnit to test our compiler using this class.
 */
public class CompilerTest {

	/**
	 * Test standard expressions.
	 */
	@Test
	public void testExpressions() {
		assertTrue(testFile("tests/expressions_correct.nt","true\ntrue\ntrue\ntrue\ntrue\ntrue\n",null));
	}

	/**
	 * Test compound expressions.
	 */
	@Test
	public void testCompoundExpressions() {
		assertTrue(testFile("tests/compound_expressions_correct.nt","true\n2\ntrue\ntrue\nfalse\nb\na\n",null));
	}

	/**
	 * Test assignments.
	 */
	@Test
	public void testAssignments() {
		assertTrue(testFile("tests/assignment_correct.nt","0\n0\ntrue\nz\n",null));
	}

	/**
	 * Test if and else statements.
	 */
	@Test
	public void testIfElse() {
		assertTrue(testFile("tests/if_else_correct.nt","2\n2\nb\na\n1\n",null));
	}

	/**
	 * Test while statement.
	 */
	@Test
	public void testWhile() {
		assertTrue(testFile("tests/while_correct.nt","2\n3\n4\n",null));
	}

	/**
	 * Help function to be used by the test methods. It calls the compiler and
	 * intercepts the print to the system out. Than it compares the actual result
	 * of the program with the expected result.
	 * 
	 * Use the input parameter for input to for example the read() statement.
	 *
	 * @param inputFile the input file
	 * @param expectedOutput the expected output, use \n for line breaks
	 * @param input the input
	 * @return true, if successful
	 */
	private boolean testFile(String inputFile, String expectedOutput, String input)
	{
		try
		{
			System.out.println("** Testing " + inputFile + " **");
			
			PrintStream standardOut = System.out;
			ByteArrayOutputStream resultOut = new ByteArrayOutputStream();
			PrintStream resultPrintOut = new PrintStream(resultOut);
			System.setOut(resultPrintOut);

			Compiler c = new Compiler();
			boolean compileResult = c.compile(inputFile, true, false, true);

			System.setOut(standardOut);
			resultPrintOut.close();
			resultOut.close();
			
			if(compileResult == false) return false;

			System.out.println("- Expected Result -");
			System.out.print(expectedOutput);

			String resultString = new String(resultOut.toByteArray(), Charset.defaultCharset());

			System.out.println("- Result -");
			System.out.print(resultString);

			return expectedOutput.equals(resultString);
		}
		catch (IOException e)
		{
			return false;
		}
	}

}
