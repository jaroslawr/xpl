package xpl;

import xpl.exceptions.*;

import xpl.semantic.ast.ASTNode;
import xpl.semantic.ast.ASTNodeTreeAdaptor;
import xpl.semantic.SemanticAnalysis;

import xpl.codegen.CodeGeneration;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class XplCompiler {
  public XplCompiler(String[] args) { this.args = args; }

  private String[] args;

  private ASTNodeTreeAdaptor adaptor = new ASTNodeTreeAdaptor();

  private XplLexer lexer;
  private XplParser parser;
  private ASTNode ast;
  private CommonTokenStream tokens;
  private CommonTreeNodeStream nodes;
  private SemanticAnalysis semanticAnalysis;
  private CodeGeneration codeGeneration;

  public void go() {
    try {
      if(args.length != 2) {
	System.out.println("Syntax: xpl [input file name] [output filename]");
	return;
      }

      System.out.println("Compiling " + args[0] + "...");
      System.out.println();

      parse(); semanticAnalysis(); codeGeneration();

      System.out.println("Compilations was successfull.");
    }
    catch(SyntacticAnalysisError e) {
      System.out.println("Syntax errors: ");
      System.out.println();
      for(String error : parser.getErrors())
	System.out.println(error);
      System.out.println();
      System.out.println("Compilation failed.");
    }
    catch(SemanticAnalysisError e) {
      System.out.println("Semantic errors: ");
      System.out.println();
      for(String error : semanticAnalysis.getErrors())
	System.out.println(error);
      System.out.println();
      System.out.println("Compilation failed.");
    }
    catch(RecognitionException e)  {
      System.out.println(e);
      System.out.println("Internal error, bailing out");
    }
    catch(IOException e) {
      System.out.println("Input/output error, compilation failed");
    }
  }

  private void parse() throws IOException, RecognitionException {
    lexer  = new XplLexer(new ANTLRInputStream(new FileInputStream(args[0])));
    tokens = new CommonTokenStream(lexer);
    parser = new XplParser(tokens);

    parser.setTreeAdaptor(adaptor);

    ast    = (ASTNode) parser.program().getTree();
    nodes  = new CommonTreeNodeStream((CommonTree) ast);
    nodes.setTokenStream(tokens);
  }

  private void semanticAnalysis() throws RecognitionException {
    semanticAnalysis = new SemanticAnalysis(nodes);
    semanticAnalysis.setTreeAdaptor(adaptor);
    semanticAnalysis.program();

    nodes  = new CommonTreeNodeStream((CommonTree) ast);
    nodes.setTokenStream(tokens);
  }

  private void codeGeneration() throws RecognitionException {
    codeGeneration = new CodeGeneration(nodes, args[1]);
    codeGeneration.program();
  }
}

