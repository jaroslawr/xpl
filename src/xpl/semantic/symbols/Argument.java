package xpl.semantic.symbols;

import xpl.semantic.Type;

public class Argument extends Identifier {
  public Argument(Type type, String name, int id) {
    super(type, name);
    this.id = id;
  }

  private int id;
  public  int getId() { return id; }
}
