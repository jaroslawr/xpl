import org.junit.*;
import static org.junit.Assert.*;

import xpl.semantic.*;
import xpl.semantic.symbols.*;

public class SymbolTableTest {
  @Test
  public void storesArguments() {
    SymbolTable table = new SymbolTable();

    Argument argument = new Argument(Types.Integer, "foobar", 1);
    table.put(argument);

    Argument found = table.findArgument("foobar");
    assertEquals(argument, found);
  }

  @Test
  public void storesLocalVariables() {
    SymbolTable table = new SymbolTable();

    Variable variable = new Variable(Types.Integer, "foobar", 0);
    table.put(variable);

    Variable found = table.findVariable("foobar");
    assertEquals(variable, found);
  }

  @Test
  public void storesMethods() {
    SymbolTable table = new SymbolTable();

    Method method = new Method(Types.Integer, "foobar", new Type[] { Types.Integer, Types.Integer, Types.Integer });
    table.put(method);

    Method found = table.findMethod("foobar");
    assertEquals(method, found);
  }

  @Test
  public void ignoresItemsOfDifferentTypeWhenLookingUpSymbols() {
    SymbolTable   table    = new SymbolTable();
    Method        method   = new Method(Types.Integer, "foobar", new Type[] { Types.Integer, Types.Integer, Types.Integer });
    Variable      variable = new Variable(Types.Integer, "foobar", 0);

    table.put(method);
    table.enterNewFrame();
    table.put(variable);

    Method found = table.findMethod("foobar");
    assertEquals(method, found);
  }
}
