package xpl.codegen;

import xpl.semantic.Types;
import xpl.semantic.ast.ASTNode;

public class CodeGeneratorArithmetic extends CodeGeneratorModule {
  public CodeGeneratorArithmetic(Context context) { super(context); }

  public void add(ASTNode node) {
    currentMethod.visitInsn(InstructionSet.ADD(node.getNodeType()));
  }

  public void subtract(ASTNode node) {
    currentMethod.visitInsn(InstructionSet.SUB(node.getNodeType()));
  }

  public void multiply(ASTNode node) {
    currentMethod.visitInsn(InstructionSet.MUL(node.getNodeType()));
  }

  public void divide(ASTNode node) {
    currentMethod.visitInsn(InstructionSet.DIV(node.getNodeType()));
  }

  public void mod(ASTNode node) {
    currentMethod.visitInsn(InstructionSet.REM(node.getNodeType()));
  }

  public void negate(ASTNode node) {
    currentMethod.visitInsn(InstructionSet.NEG(node.getNodeType()));
  }
}
