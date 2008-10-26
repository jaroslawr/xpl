import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.Token;
import org.antlr.runtime.CommonToken;

public class ASTNode extends CommonTree {
  public ASTNode(Token t)                   { super(t); }
  public ASTNode(int ttype, String text)    { super(new CommonToken(ttype, text)); }

  public ASTNode(ASTNode node) {
    super(node.getToken());

    this.nodeType = node.nodeType;
    this.frameId  = node.frameId;
    this.hasElse  = node.hasElse;
  }

  private int  frameId = 13;
  public  int  getFrameId()               { return this.frameId; }
  public  void setFrameId(int frameId)    { this.frameId = frameId; }

  private Type nodeType;
  public  Type getNodeType()              { return this.nodeType; }
  public  void setNodeType(Type nodeType) { this.nodeType = nodeType; }
  public  boolean isOf(Type nodeType)     { return this.nodeType != null && this.nodeType.equals(nodeType); }

  public boolean hasElse = false;
}
