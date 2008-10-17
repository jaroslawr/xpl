import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.Token;
import org.antlr.runtime.CommonToken;

public class ASTNode extends CommonTree {
  public ASTNode(Token t)                   { super(t); }
  public ASTNode(int ttype, String text)    { super(new CommonToken(ttype, text)); }

  public ASTNode(ASTNode node) {
    super(node.getToken());

    this.expType = node.expType;
    this.frameId = node.frameId;
    this.hasElse = node.hasElse;
  }

  private int frameId = 13;
  public  int  getFrameId()                 { return this.frameId; }
  public  void setFrameId(int frameId)      { this.frameId = frameId; }

  private String expType;
  public  String getExpType()               { return expType; }
  public  void   setExpType(String expType) { this.expType = expType; }

  public boolean hasElse = false;
}
