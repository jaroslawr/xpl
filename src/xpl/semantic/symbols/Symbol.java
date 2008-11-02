package xpl.semantic.symbols;

import xpl.semantic.Type;

public abstract class Symbol {
  public Symbol() {}

  public Symbol(String name) {
    this.name = name;
  }

  protected String name;
  public String getName() { return name; }
}
