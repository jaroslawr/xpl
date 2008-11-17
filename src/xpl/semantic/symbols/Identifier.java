package xpl.semantic.symbols;

import xpl.semantic.Type;

public abstract class Identifier extends Symbol {
  public Identifier(int scopeId, Type type, String name) {
    super(scopeId, name);
    this.type = type;
  }

  private Type   type;
  public  Type   getType()       { return type; }
  public  String typeSignature() { return type.getSignature(); }
}
