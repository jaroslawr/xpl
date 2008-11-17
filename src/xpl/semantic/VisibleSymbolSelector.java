package xpl.semantic;

import java.util.*;

import xpl.semantic.symbols.*;

public class VisibleSymbolSelector implements Selector<Symbol> {
  VisibleSymbolSelector(Stack<Integer> scopes) {
    this.scopes = scopes;
  }

  public boolean select(Symbol symbol) {
    for (ListIterator<Integer> it = scopes.listIterator(scopes.size()); it.hasPrevious();) {
      int scopeId = it.previous();
      if(type.isInstance(symbol) && symbol.getScopeId() == scopeId)
       	return true;
    }
    return false;
  }

  public VisibleSymbolSelector withType(Class type) {
    this.type = type;
    return this;
  }

  private Class<Symbol> type = Symbol.class;

  private Stack<Integer> scopes;
}
