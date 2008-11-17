package xpl.semantic.symbols;

import xpl.semantic.Type;

public class Variable extends Identifier {
  public Variable(int scopeId, Type type, String name, int id) {
    super(scopeId, type, name);
    this.variableId = "variable" + id;
  }

  private String variableId;
  public String getVariableId()  {
    return variableId;
  }
}
