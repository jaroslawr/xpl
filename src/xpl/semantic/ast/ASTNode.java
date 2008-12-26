package xpl.semantic.ast;

import xpl.semantic.Type;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.Token;
import org.antlr.runtime.CommonToken;

public class ASTNode extends CommonTree {
  public ASTNode(Token t) {
    super(t);
  }

  public ASTNode(int ttype, String text) {
    super(new CommonToken(ttype, text));
  }

  public ASTNode(int ttype, Type type) {
    super(new CommonToken(ttype));
    setNodeType(type);
  }

  public ASTNode(ASTNode node) {
    super(node.getToken());
    setNodeType(node.nodeType);

    this.hasElse  = node.hasElse;
  }

  private Type nodeType;

  public Type getNodeType() {
    return this.nodeType;
  }

  public void setNodeType(Type nodeType) {
    this.nodeType = nodeType;
  }
  public boolean isOf(Type nodeType) {
    return this.nodeType != null && this.nodeType.equals(nodeType);
  }

  private Type typeToPromoteTo;

  public void setTypeToPromoteTo(Type type) {
    this.typeToPromoteTo = type;
  }

  public Type getTypeToPromoteTo() {
    return typeToPromoteTo;
  }

  public boolean hasElse = false;
}
