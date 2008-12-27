package xpl.codegen;

import xpl.semantic.ast.ASTNode;
import xpl.semantic.Type;
import xpl.semantic.Types;

public class CodeGeneratorConstant extends CodeGeneratorModule {
  public CodeGeneratorConstant(Context context) { super(context); }

  public void load(ASTNode node) {
    Object constant = parseConstant(node.getNodeType(), node.getText());
    currentMethod.visitLdcInsn(constant);
    promoteType(node);
  }

  private Object parseConstant(Type type, String literal) {
    if(type == Types.Integer)
      return Integer.parseInt(literal);
    return Double.parseDouble(literal);
  }
}
