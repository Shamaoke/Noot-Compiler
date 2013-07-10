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
package noot.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import noot.Compiler;
import noot.exceptions.LexerParserException;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

/**
 * The Class CompilerTest.
 *
 * We can use JUnit to test our compiler using this class.
 */
public class CompilerTest {

	/**
	 * Test standard expressions.
	 * 
	 * Testing several expressions and their evaluation levels.
	 */
	@Test
	public void testCorrectExpressions() {
		assertTrue(testFile("tests/expressions_correct.nt","true\ntrue\ntrue\ntrue\ntrue\ntrue\n",null));
	}

	/**
	 * Test compound expressions.
	 * 
	 * Testing several compound expressions. Some with nested return.
	 */
	@Test
	public void testCorrectCompoundExpressions() {
		assertTrue(testFile("tests/compound_expressions_correct.nt","true\n2\ntrue\ntrue\nfalse\nb\na\n",null));
	}
	
	/**
	 * Test the read and print statements.
	 * 
	 * Testing several constructions of correct read and print statments.
	 * Also in combination with the assign statements.
	 */
	@Test
	public void testCorrectReadPrint() {
		assertTrue(testFile("tests/read_print_correct.nt","Enter integer: Enter integer: 1\n2\nEnter integer: 3\n3\nEnter boolean (0/1): Enter character: true\ntrue\nc\ntrue\n0\ntrue\ntrue\n","1\n2\n3\n1\nc\n"));
	}

	/**
	 * Test assignments.
	 * 
	 * Testing several assign statements.
	 */
	@Test
	public void testCorrectAssignments() {
		assertTrue(testFile("tests/assignment_correct.nt","0\n0\ntrue\nz\n",null));
		
	}

	/**
	 * Test if and else statements.
	 * 
	 * Testing several if and else statement variants. With and without return and assign.
	 */
	@Test
	public void testCorrectIfElse() {
		assertTrue(testFile("tests/if_else_correct.nt","2\n2\nb\na\n1\n",null));
	}

	/**
	 * Test while statement.
	 * 
	 * Testing a simple while loop.
	 */
	@Test
	public void testCorrectWhile() {
		assertTrue(testFile("tests/while_correct.nt","2\n3\n4\n",null));
	}
	
	/**
	 * Test incorrect assignment1.
	 * 
	 * Tries to assign with the wrong type. This should fail.
	 */
	@Test
	public void testIncorrectAssignment1()
	{
		assertTrue(testFile("tests/assignment1_incorrect.nt","true[line:5 char:6] :: BOOL expression expected to be INT so all expressions have the same type, this is needed in order to use the := operator.\n",null));
	}
	
	/**
	 * Test incorrect assignment2.
	 * 
	 * Tries to assign a constant. This should fail.
	 */
	@Test
	public void testIncorrectAssignment2()
	{
		assertTrue(testFile("tests/assignment2_incorrect.nt",":=[line:5 char:3] :: Trying to reassign constant, this is not allowed.\n",null));
	}
	
	/**
	 * Test incorrect compound expressions.
	 * 
	 * Declaration typed as last argument in a compound expression
	 * this is not allowed and the program should fail.
	 */
	@Test
	public void testIncorrectCompoundExpressions()
	{
		assertTrue(testFile("tests/compound_expressions_incorrect.nt","int[line:5 char:1] :: Last command in compound expression is a declaration, this is not allowed.\n",null));
	}
	
	/**
	 * Test incorrect declaration scope.
	 * 
	 * Tries to declare an identifier that has already
	 * been declared in the current scope.
	 */
	@Test
	public void testIncorrectDeclarationScope()
	{
		assertTrue(testFile("tests/declaration_scope_incorrect.nt","i1[line:14 char:6] :: i1 has already been declared in current scope.\n",null));
	}
	
	/**
	 * Test incorrect identifier.
	 * 
	 * Tries to assign an identifier that has not been declared.
	 */
	@Test
	public void testIncorrectIdentifier()
	{
		assertTrue(testFile("tests/identifier_incorrect.nt","i2[line:10 char:6] :: i2 has not been declared.\n",null));
	}
	
	/**
	 * Test incorrect if else1.
	 * 
	 * Tries to assign an if statement with int as return to a boolean.
	 * This should fail.
	 */
	@Test
	public void testIncorrectIfElse1()
	{
		assertTrue(testFile("tests/if_else1_incorrect.nt","if[line:8 char:6] :: INT expression expected to be BOOL so all expressions have the same type, this is needed in order to use the := operator.\n",null));
	}
	
	/**
	 * Test incorrect if else2.
	 * 
	 * Tries to assign a variable with the result of an if statement with different
	 * types. The else has an int as type and the if has an char as type. Since the
	 * types are different the statement results as void and a void can't be assigned.
	 */
	@Test
	public void testIncorrectIfElse2()
	{
		assertTrue(testFile("tests/if_else2_incorrect.nt","if[line:10 char:6] :: VOID expression expected to be BOOL so all expressions have the same type, this is needed in order to use the := operator.\n",null));
	}
	
	/**
	 * Test incorrect if else3.
	 * 
	 * Tries to assign a variable with the result of an if statement without else.
	 * This should not work since the type of an if statement
	 * without else is void.
	 */
	@Test
	public void testIncorrectIfElse3()
	{
		assertTrue(testFile("tests/if_else3_incorrect.nt","if[line:8 char:6] :: VOID expression expected to be BOOL so all expressions have the same type, this is needed in order to use the := operator.\n",null));
	}
	
	/**
	 * Test incorrect read print1.
	 * 
	 * Tries to read a constant, this should not be allowed.
	 */
	@Test
	public void testIncorrectReadPrint1()
	{
		assertTrue(testFile("tests/read_print1_incorrect.nt","read[line:5 char:0] :: Trying to read constant, this is not allowed.\n","2\n"));
	}
	
	/**
	 * Test incorrect read print2.
	 * 
	 * Tries to enter a void argument into print. This should not be allowed.
	 */
	@Test
	public void testIncorrectReadPrint2()
	{
		assertTrue(testFile("tests/read_print2_incorrect.nt","print[line:7 char:6] :: Print argument is a void expression, this is not allowed.\n",null));
	}
	
	/**
	 * Test incorrect type1.
	 * 
	 * Tries to enter an int into the && operator. This should not be allowed since the && operator should only except bools.
	 */
	@Test
	public void testIncorrectType1()
	{
		assertTrue(testFile("tests/specific_type1_incorrect.nt","1[line:3 char:14] :: INT expression needs to be BOOL in order to use it with the && operator.\n",null));
	}
	
	/**
	 * Test incorrect type2.
	 * 
	 * Tries to enter a bool into the > operator. This should not be allowed since the > operator should only except ints;
	 */
	@Test
	public void testIncorrectType2()
	{
		assertTrue(testFile("tests/specific_type2_incorrect.nt","true[line:3 char:6] :: BOOL expression needs to be INT in order to use it with the > operator.\n",null));
	}

	/**
	 * Test incorrect spelling.
	 * 
	 * This will generate a lexing error because a token is not spelled correctly (=).
	 */
	@Test
	public void testIncorrectSpelling1()
	{
		assertTrue(testFile("tests/incorrect_spelling1.nt","Lexing error on line: 3\n",null));
	}
	
	/**
	 * Test incorrect spelling.
	 * 
	 * This will generate a parsing error because an token is missing, namely the } token.
	 */
	@Test
	public void testIncorrectSpelling2()
	{
		assertTrue(testFile("tests/incorrect_spelling2.nt","Parsing error on line: 17\n",null));
	}
	
	/**
	 * Test incorrect at runtime.
	 * 
	 * This will halt the program because of devide by zero.
	 */
	@Test
	public void testIncorrectRuntime()
	{
		assertTrue(testFile("tests/runtime_incorrect.nt","Program has failed due to division by zero.\n",null));
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
		System.out.println("\n\n\n*** Testing " + inputFile + " ***");
		
		// For printing the content of the file
		try {
			FileReader fileReader = new FileReader (inputFile);
			int inChar;
			while ( (inChar = fileReader.read()) != -1 ) {
			   System.out.printf ("%c", inChar);
			}
			fileReader.close();
			
			System.out.println("");
		} catch (IOException e1) {
			return false;
		}
		
		PrintStream standardOut = System.out;
		InputStream standardIn = System.in;
		
		ByteArrayOutputStream resultOut = new ByteArrayOutputStream();
		PrintStream resultPrintOut = new PrintStream(resultOut);
		
		try
		{
			System.setOut(resultPrintOut);
			
			if(input != null)
			{
				InputStream inputStream = new ByteArrayInputStream( input.getBytes(Charset.defaultCharset()) );
				System.setIn( inputStream );
			}

			Compiler c = new Compiler();
			c.compile(inputFile, true, false, true);
			
			if(input != null) System.setIn( standardIn );
			
			resultPrintOut.close();
			resultOut.close();
			
		} 
		catch (RecognitionException e)
		{
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			return false;
		}
		catch (LexerParserException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.setOut(standardOut);
		}
		
		System.out.println("* Expected Result *");
		System.out.print(expectedOutput);

		String resultString = new String(resultOut.toByteArray(), Charset.defaultCharset());

		System.out.println("* Result *");
		System.out.print(resultString);

		return expectedOutput.equals(resultString);
	}

}
