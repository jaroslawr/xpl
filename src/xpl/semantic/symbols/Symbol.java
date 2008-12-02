package xpl.semantic.symbols;

import xpl.semantic.Type;

public abstract class Symbol {
  public Symbol() {}

  public Symbol(int scopeId, String name) {
    this.scopeId = scopeId;
    this.name    = name;
  }

  protected String name;
  public    String getName() { return name; }

  protected int scopeId;
  public    int getScopeId() { return scopeId; }

  public String toString() {
    return "[" + scopeId + "]: " + name;
  }
}
