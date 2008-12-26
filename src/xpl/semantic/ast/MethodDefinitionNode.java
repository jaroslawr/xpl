package xpl.semantic.ast;

import xpl.semantic.symbols.Method;
import xpl.semantic.ast.MethodNode;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.Tree;

public class MethodDefinitionNode extends MethodNode {
  public MethodDefinitionNode(int ttype) {
    super(new CommonToken(ttype, "METHOD"));
  }

  public MethodDefinitionNode(MethodDefinitionNode node) {
    super(node);
  }

  public Tree dupNode() {
    return new MethodDefinitionNode(this);
  }
}
