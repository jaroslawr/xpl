import java.util.*;

public class Scope {
  public Scope(Scope parent) { this.parent = parent; }

  private Scope parent = null;
  public  Scope getParentScope() { return parent; }

  private Hashtable<String, Symbol> symbols = new Hashtable<String, Symbol>();

  private int argumentsCount = 1;
  public  int getArgumentsCount() { return argumentsCount; }

  private static int localVariablesCount = 0;

  public Argument addArgument(String name) {
    Argument arg = new Argument(name, argumentsCount++);
    symbols.put(name, arg);
    return arg;
  }

  public LocalVariable addLocalVariable(String name) {
    LocalVariable var = new LocalVariable(name, localVariablesCount++);
    symbols.put(name, var);
    return var;
  }

  public Method addMethod(String name, int arity) {
    Method method = new Method(name, arity);
    symbols.put(name, method);
    return method;
  }

  public Variable      findVariable(String name)      { return (Variable)      find(name, "variable"); }
  public Argument      findArgument(String name)      { return (Argument)      find(name, "argument"); }
  public LocalVariable findLocalVariable(String name) { return (LocalVariable) find(name, "local-variable"); }
  public Method        findMethod(String name)        { return (Method)        find(name, "method"); }

  private Symbol find(String name, String type) {
    Symbol sym = symbols.get(name);
    if(sym != null && sym.isOfType(type))
      return sym;
    return parent == null ? null : parent.find(name, type);
  }

  public String toString() {
    String result = symbols.toString() + "\n";
    if(parent != null)
      result += "  " + parent.toString();
    return result;
  }
}
