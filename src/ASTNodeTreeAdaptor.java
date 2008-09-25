import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class ASTNodeTreeAdaptor extends CommonTreeAdaptor {
  public Object create(Token token) {
    return new ASTNode(token);
  }

  public Object dupNode(Object t){
    return t == null ? t : create(((ASTNode)t).token);
  }
}
