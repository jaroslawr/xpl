public class Method extends Symbol {
  public Method(Type returnType, String name, Type[] argumentTypes) {
    super(name);
    this.returnType    = returnType;
    this.argumentTypes = argumentTypes;
  }

  public Method(Type returnType, String name, Type[] argumentTypes, boolean builtin) {
    this(returnType, name, argumentTypes);
    this.builtin = builtin;
  }

  private boolean builtin = false;
  public  boolean isBuiltin() { return builtin; }

  private Type   returnType;
  private Type[] argumentTypes;
  public  int    getArity() { return argumentTypes.length; }

  public String getArgumentsSignature() {
    String result = "";
    for(Type type : argumentTypes)
      result += type.getSignature();
    return result;
  }

  public String getSignature() {
    return "(" + getArgumentsSignature() + ")" + returnType.getSignature();
  }
}
