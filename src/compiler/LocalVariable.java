public class LocalVariable extends Variable {
  private String variableId;

  public LocalVariable(Type type, String name, int id) {
    super(type, name);
    this.variableId = "variable" + id;
  }

  public String getVariableId()  {
    return variableId;
  }
}
