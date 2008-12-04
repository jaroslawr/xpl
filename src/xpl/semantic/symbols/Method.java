package xpl.semantic.symbols;

import xpl.semantic.Type;

public class Method extends Symbol {
  public Method(int scopeId, Type returnType, String name, Type[] argumentTypes) {
    super(scopeId, name);
    this.returnType    = returnType;
    this.argumentTypes = argumentTypes;
  }

  public Method(int scopeId, Type returnType, String name, Type[] argumentTypes, boolean builtin) {
    this(scopeId, returnType, name, argumentTypes);
    this.builtin = builtin;
  }

  private boolean builtin = false;
  public  boolean isBuiltin() { return builtin; }

  private Type   returnType;
  public  Type   getReturnType() { return returnType; }

  private Type[] argumentTypes;
  public  Type[] getArgumentTypes() { return argumentTypes; }
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

  public String toString() {
    String result = "(" + super.toString() + ", method, signature: ";
    for(Type type : argumentTypes) {
      result += type.toString();
      result += " ";
    }
    result += ")";
    return result;
  }
}
