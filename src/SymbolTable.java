import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.*;

public class SymbolTable implements Opcodes {
  private Scope currentScope = null;

  public Scope enterScope() {
    currentScope = new Scope(currentScope);
    return currentScope;
  }

  public Scope exitScope()  {
    Scope scope  = currentScope;
    currentScope = scope.getParentScope();
    return scope;
  }

  public Scope addMethod(String name, ArrayList<String> args) {
    currentScope.createMethod(name, args.size());
    Scope scope = enterScope();
    for(String arg : args) currentScope.createArgument(arg);
    return scope;
  }

  public void addLocalVariable(String name) {
    currentScope.createLocalVariable(name);
  }

  public Symbol lookup(String name) {
    return currentScope.lookup(name);
  }

  public LocalVariable lookupLocalVariable(String name) {
    Symbol sym = lookup(name);
    return sym != null && sym.isOfType("local-variable") ? (LocalVariable) sym : null;
  }

  public String toString() {
    return currentScope.toString();
  }
}
