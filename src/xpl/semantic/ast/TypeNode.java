package xpl.semantic.ast;

import xpl.semantic.Type;
import xpl.semantic.Types;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;

public class TypeNode extends ASTNode {
  public TypeNode(Token tok) {
    super(tok);

    if(tok.getText().equals("int"))
      representedType = Types.Integer;
    else if(tok.getText().equals("string"))
      representedType = Types.String;
    else if(tok.getText().equals("void"))
      representedType = Types.Void;
  }

  public TypeNode(TypeNode node) { super(node); }

  public Tree dupNode() {
    return new TypeNode(this);
  }

  private Type representedType;
  public  Type getRepresentedType() { return representedType; }
}
