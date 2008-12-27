package xpl.semantic;

import java.util.*;

import xpl.semantic.symbols.*;

public class VisibleMethodSelector implements Selector<Symbol> {
  VisibleMethodSelector(Stack<Integer> scopes) {
    this.scopes = scopes;
  }

  public boolean select(Symbol symbol) {
    lookup:
    for (ListIterator<Integer> it = scopes.listIterator(scopes.size()); it.hasPrevious();) {
      int scopeId = it.previous();
      if(Method.class.isInstance(symbol)) {
        Method tried = (Method) symbol;
        if(tried.getScopeId() == scopeId && tried.getArity() == callSignature.length) {
          Type[] triedSignature = tried.getArgumentTypes();
          for(int i = 0; i < triedSignature.length; i++)
            if(!triedSignature[i].equals(callSignature[i]))
              continue lookup;

          return true;
        }
      }
    }
    return false;
  }

  public VisibleMethodSelector withCallSignature(Type[] callSignature) {
    this.callSignature = callSignature;
    return this;
  }

  private Type[] callSignature;

  private Stack<Integer> scopes;
}
