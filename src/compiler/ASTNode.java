import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.Token;
import org.antlr.runtime.CommonToken;

public class ASTNode extends CommonTree {
  public ASTNode(Token t)                   { super(t); }
  public ASTNode(int ttype, String text)    { super(new CommonToken(ttype, text));	}

  private int frameId;
  public  int  getFrameId()                 { return this.frameId; }
  public  void setFrameId(int frameId)      { this.frameId = frameId; }

  private String expType;
  public  String getExpType()               { return expType; }
  public  void   setExpType(String expType) { this.expType = expType; }

  public String toString() {
    return "(" + super.toString() + " type: " + expType + ")";
  }
}
