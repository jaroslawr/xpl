package xpl.semantic.ast;

import xpl.semantic.symbols.Method;
import xpl.semantic.ast.MethodNode;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.Tree;

public class MethodCallNode extends MethodNode {
  public MethodCallNode(int ttype) {
    super(new CommonToken(ttype, "CALL"));
  }

  public MethodCallNode(MethodCallNode node) {
    super(node);
  }

  public Tree dupNode() {
    return new MethodCallNode(this);
  }
}
