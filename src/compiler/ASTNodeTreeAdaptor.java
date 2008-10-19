import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class ASTNodeTreeAdaptor extends CommonTreeAdaptor {
  public Object create(Token token) {
    return new ASTNode(token);
  }

  public Object dupNode(Object t){
    return t == null ? t : new ASTNode((ASTNode)t);
  }

  public Object getParent(Object t) {
    return t == null ? t : ((Tree)t).getParent();
  }

  public Object errorNode(TokenStream input, Token start, Token stop, RecognitionException e) {
    return new ASTErrorNode(input, start, stop, e);
  }
}
