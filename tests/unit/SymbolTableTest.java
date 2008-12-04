import org.junit.*;
import static org.junit.Assert.*;

import xpl.semantic.*;
import xpl.semantic.symbols.*;

import java.util.*;

public class SymbolTableTest {
  @Test
  public void storesArguments() {
    SymbolTable table = new SymbolTable();

    Argument argument = new Argument(table.getCurrentScopeId(), Types.Integer, "foobar", 1);
    table.put(argument);

    Argument found = table.findArgument("foobar");
    assertEquals(argument, found);
  }

  @Test
  public void storesLocalVariables() {
    SymbolTable table = new SymbolTable();

    Variable variable = new Variable(table.getCurrentScopeId(), Types.Integer, "foobar", 0);
    table.put(variable);

    Variable found = table.findVariable("foobar");
    assertEquals(variable, found);
  }

  @Test
  public void storesMethods() {
    SymbolTable table  = new SymbolTable();
    Type[]      sig    = new Type[] { Types.Integer, Types.Integer, Types.Integer };
    Method      method = new Method(table.getCurrentScopeId(), Types.Integer, "foobar", sig);

    table.put(method);

    Method found = table.findMethod("foobar", sig);
    assertEquals(method, found);
  }

  @Test
  public void ignoresItemsOfDifferentTypeWhenLookingUpSymbols() {
    SymbolTable table  = new SymbolTable();
    Type[]      sig    = new Type[] { Types.Integer, Types.Integer, Types.Integer };
    Method      method = new Method(table.getCurrentScopeId(), Types.Integer, "foobar", sig);

    table.put(method);

    table.enterScope();

    Variable variable = new Variable(table.getCurrentScopeId(), Types.Integer, "foobar", 0);
    table.put(variable);

    Method found = table.findMethod("foobar", sig);
    assertEquals(method, found);
  }
}
