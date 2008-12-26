package xpl.codegen;

import xpl.semantic.ast.ASTNode;

public class CodeGeneratorString extends CodeGeneratorModule {
  public CodeGeneratorString(Context context) { super(context); }

  public void builder() {
    currentMethod.visitTypeInsn(NEW, "java/lang/StringBuilder");
    currentMethod.visitInsn(DUP);
    currentMethod.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V");
  }

  public void append(ASTNode node) {
    String signature = "(" + node.getNodeType().getSignature() + ")Ljava/lang/StringBuilder;";
    currentMethod.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", signature);
  }

  public void finish() {
    currentMethod.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
  }

  public void load(ASTNode node) {
    currentMethod.visitLdcInsn(strip(node.getText()));
  }

  private String strip(String literal) {
    return literal.substring(1, literal.length() - 1);
  }
}
