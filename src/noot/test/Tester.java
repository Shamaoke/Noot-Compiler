package noot.test;

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

import TAM.Assembler;
import TAM.Interpreter;

public class Tester {
	
//	public static void main(String[] args) {
//		
//		testFile("tests/expressions_correct.nt","true\ntrue\ntrue\ntrue\ntrue\ntrue\n",null);
//		//testFile("tests/assignment_correct.nt",null,null);
//		//assert(testFile("tests/read_print_correct.nt",null,null));
//		assert(testFile("tests/compound_expressions_correct.nt","true\n2\ntrue\ntrue\nfalse\nb\na\n",null));
//		assert(testFile("tests/if_else_correct.nt",null,null));
//		assert(testFile("tests/while_correct.nt",null,null));
//		
//	}
}
