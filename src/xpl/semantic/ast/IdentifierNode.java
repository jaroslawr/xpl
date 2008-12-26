package xpl.semantic.ast;

import xpl.semantic.symbols.Identifier;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;

public class IdentifierNode extends ASTNode {
  public IdentifierNode(Token t) {
    super(t);
  }

  public IdentifierNode(IdentifierNode node) {
    super(node);
  }

  public Tree dupNode() {
    return new IdentifierNode(this);
  }

  private Identifier identifierSymbol;

  public Identifier getIdentifier() {
    return identifierSymbol;
  }

  public void setIdentifier(Identifier identifierSymbol) {
    this.identifierSymbol = identifierSymbol;
  }
}
