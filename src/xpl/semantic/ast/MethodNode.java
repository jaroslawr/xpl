package xpl.semantic.ast;

import xpl.semantic.symbols.Method;

import org.antlr.runtime.CommonToken;

public abstract class MethodNode extends ASTNode {
  public MethodNode(CommonToken token) {
    super(token);
  }

  public MethodNode(MethodNode node) {
    super(node);
  }

  private Method methodSymbol;

  public Method getMethod() {
    return methodSymbol;
  }

  public void setMethod(Method methodSymbol) {
    this.methodSymbol = methodSymbol;
  }
}
