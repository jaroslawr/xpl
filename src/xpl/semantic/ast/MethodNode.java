package xpl.semantic.ast;

import xpl.semantic.symbols.Method;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.Tree;

public class MethodNode extends ASTNode {
  public MethodNode(int ttype)       { super(new CommonToken(ttype, "CALL")); }
  public MethodNode(MethodNode node) { super(node); }

  public Tree dupNode() {
    return new MethodNode(this);
  }

  private Method methodSymbol;
  public  Method getMethod()                    { return methodSymbol; }
  public  void   setMethod(Method methodSymbol) { this.methodSymbol = methodSymbol; }
}
