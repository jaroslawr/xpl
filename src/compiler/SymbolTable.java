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
    currentScope.addMethod(name, args.size());
    Scope scope = enterScope();
    for(String arg : args) currentScope.addArgument(arg);
    return scope;
  }

  public void addLocalVariable(String name) {
    currentScope.addLocalVariable(name);
  }

  public Variable findVariable(String name) {
    return currentScope.findVariable(name);
  }

  public Argument findArgument(String name) {
    return currentScope.findArgument(name);
  }

  public LocalVariable findLocalVariable(String name) {
    return currentScope.findLocalVariable(name);
  }

  public Method findMethod(String name) {
    return currentScope.findMethod(name);
  }

  public String toString() {
    return currentScope.toString();
  }
}
