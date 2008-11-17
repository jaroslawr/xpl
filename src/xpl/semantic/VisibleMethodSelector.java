package xpl.semantic;

import java.util.*;

import xpl.semantic.symbols.*;

public class VisibleMethodSelector implements Selector<Symbol> {
  VisibleMethodSelector(Stack<Integer> scopes) {
    this.scopes = scopes;
  }

  public boolean select(Symbol symbol) {
    for (ListIterator<Integer> it = scopes.listIterator(scopes.size()); it.hasPrevious();) {
      int scopeId = it.previous();
      if(Method.class.isInstance(symbol)) {
	Method method = (Method) symbol;
	if(method.getScopeId() == scopeId && method.getArity() == arity)
	  return true;
      }
    }
    return false;
  }

  public VisibleMethodSelector withArity(int arity) {
    this.arity = arity;
    return this;
  }

  private int arity = 0;

  private Stack<Integer> scopes;
}
