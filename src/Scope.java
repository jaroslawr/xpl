import java.util.*;

public class Scope {
  public Scope(Scope parent) { this.parent = parent; }

  private Scope parent = null;
  public  Scope getParentScope() { return parent; }

  private Hashtable<String, Symbol> symbols = new Hashtable<String, Symbol>();

  private int argumentsCount = 1;
  public  int getArgumentsCount() { return argumentsCount; }

  private static int localVariablesCount = 0;

  public Argument createArgument(String name) {
    Argument arg = new Argument(name, argumentsCount++);
    symbols.put(name, arg);
    return arg;
  }

  public LocalVariable createLocalVariable(String name) {
    LocalVariable var = new LocalVariable(name, localVariablesCount++);
    symbols.put(name, var);
    return var;
  }

  public Method createMethod(String name, int arity) {
    Method method = new Method(name, arity);
    symbols.put(name, method);
    return method;
  }

  public Symbol lookup(String name) {
    Symbol sym = symbols.get(name);
    if(sym != null)
      return sym;
    return parent == null ? null : parent.lookup(name);
  }

  public String toString() {
    String result = symbols.toString() + "\n";
    if(parent != null)
      result += "  " + parent.toString();
    return result;
  }
}
