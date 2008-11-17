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
    SymbolTable table = new SymbolTable();

    Method method = new Method(table.getCurrentScopeId(), Types.Integer, "foobar", new Type[] { Types.Integer, Types.Integer, Types.Integer });
    table.put(method);

    List<Symbol> found = table.findMethods("foobar", 3);
    assertEquals(1, found.size());
    assertEquals(method, (Method) found.get(0));
  }

  @Test
  public void ignoresItemsOfDifferentTypeWhenLookingUpSymbols() {
    SymbolTable table = new SymbolTable();

    Method method = new Method(table.getCurrentScopeId(), Types.Integer, "foobar", new Type[] { Types.Integer, Types.Integer, Types.Integer });
    table.put(method);

    table.enterScope();

    Variable variable = new Variable(table.getCurrentScopeId(), Types.Integer, "foobar", 0);
    table.put(variable);

    List<Symbol> found = table.findMethods("foobar", 3);
    assertEquals(method, (Method)found.get(0));
    assertEquals(1, found.size());
  }
}
