import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.Token;
import org.antlr.runtime.CommonToken;

public class ASTNode extends CommonTree {
  public ASTNode(Token t)                { super(t); }
  public ASTNode(int ttype, String text) { super(new CommonToken(ttype, text));	}

  public Scope scope;

  public String type;

  public String toString() {
    return "(" + super.toString() + " type: " + type + ")";
  }
}
