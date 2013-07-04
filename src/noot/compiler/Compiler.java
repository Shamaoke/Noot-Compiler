package noot.compiler;

import java.io.*;
import java.util.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class Compiler {

	private static String inputFile;
	private static String outputFile;

	public static void parseOptions(String[] args)
	{
		if (args.length != 2)
		{
			System.err.println("There should be two arguments, the first for the input file, the seccond for the output");
			System.exit(1);
		}

		inputFile = args[0];
		outputFile = args[1];

	}

	public static void main(String[] args) {
		parseOptions(args);

		try {
			InputStream in = inputFile == null ? System.in : new FileInputStream(inputFile);
			NootLexer lexer = new NootLexer(new ANTLRInputStream(in));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			NootParser parser = new NootParser(tokens);

			NootParser.program_return result = parser.program();
			CommonTree tree = (CommonTree) result.getTree();
			
			// Printing the AST
			System.out.println(tree.toStringTree());


			//CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			//Checker checker = new Checker(nodes);
			//checker.program();
                        	
			//            	TreeNodeStream nodes = new BufferedTreeNodeStream(tree);
			//            	CalcGenerator generator = new CalcGenerator(nodes);
			//            	File f = new File(outputFile);
			//            	PrintStream out = new PrintStream(f);
			//            	System.setOut(out);
			//            	generator.program();
			//            	out.close();


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
