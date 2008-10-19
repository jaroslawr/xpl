import org.antlr.runtime.*;

public class ASTErrorNode extends ASTNode {
  public ASTErrorNode(TokenStream input, Token start, Token stop, RecognitionException e) {
    super(start);
  }
}
