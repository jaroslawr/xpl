package xpl.semantic.symbols;

import xpl.semantic.Type;

public class Variable extends Identifier {
  public Variable(Type type, String name, int id) {
    super(type, name);
    this.variableId = "variable" + id;
  }

  private String variableId;
  public String getVariableId()  {
    return variableId;
  }
}
