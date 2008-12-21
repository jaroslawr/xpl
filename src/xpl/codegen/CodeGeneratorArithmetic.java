package xpl.codegen;

import org.objectweb.asm.MethodVisitor;

import xpl.semantic.Types;
import xpl.semantic.ast.ASTNode;

public class CodeGeneratorArithmetic extends CodeGeneratorModule {
  public CodeGeneratorArithmetic(Context context) { super(context); }

  public void add(ASTNode additionNode) {
    if(additionNode.getNodeType() == Types.Integer)
      currentMethod.visitInsn(IADD);
    else
      currentMethod.visitInsn(DADD);
  }

  public void subtract(ASTNode substractionNode) {
    if(substractionNode.getNodeType() == Types.Integer)
      currentMethod.visitInsn(ISUB);
    else
      currentMethod.visitInsn(DSUB);
  }

  public void multiply(ASTNode multiplicationNode) {
    if(multiplicationNode.getNodeType() == Types.Integer)
      currentMethod.visitInsn(IMUL);
    else
      currentMethod.visitInsn(DMUL);
  }

  public void divide(ASTNode divisionNode)   {
    if(divisionNode.getNodeType() == Types.Integer)
      currentMethod.visitInsn(IDIV);
    else
      currentMethod.visitInsn(DDIV);
  }

  public void mod(ASTNode moduloDivisionNode) {
    if(moduloDivisionNode.getNodeType() == Types.Integer)
      currentMethod.visitInsn(IREM);
    else
      currentMethod.visitInsn(DREM);
  }

  private void promoteType(ASTNode operationNode) {
    if(operationNode.getTypeToPromoteTo() != null)
      currentMethod.visitInsn(I2D);
  }
}
