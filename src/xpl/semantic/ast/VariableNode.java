package xpl.semantic.ast;

import xpl.semantic.symbols.Variable;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;

public class VariableNode extends ASTNode {
  public VariableNode(Token t) {
    super(t);
  }

  public VariableNode(VariableNode node) {
    super(node);
  }

  public Tree dupNode() {
    return new VariableNode(this);
  }

  private Variable variableSymbol;

  public Variable getVariable() {
    return variableSymbol;
  }

  public void setVariable(Variable variableSymbol) {
    this.variableSymbol = variableSymbol;
  }
}
