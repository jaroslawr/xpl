import org.junit.*;
import static org.junit.Assert.*;

public class SymbolTableTest {
  @Test
  public void storesArguments() {
    SymbolTable table = new SymbolTable();

    Argument argument = new Argument(new Type("integer"), "foobar", 1);
    table.put(argument);

    Argument found = table.findArgument("foobar");
    assertEquals(argument, found);
  }

  @Test
  public void storesLocalVariables() {
    SymbolTable table = new SymbolTable();

    LocalVariable localVariable = new LocalVariable(new Type("integer"), "foobar", 0);
    table.put(localVariable);

    LocalVariable found = table.findLocalVariable("foobar");
    assertEquals(localVariable, found);
  }

  @Test
  public void storesMethods() {
    SymbolTable table = new SymbolTable();

    Method method = new Method(new Type("integer"), "foobar", 3);
    table.put(method);

    Method found = table.findMethod("foobar");
    assertEquals(method, found);
  }

  @Test
  public void ignoresItemsOfDifferentTypeWhenLookingUpSymbols() {
    SymbolTable   table          = new SymbolTable();
    Method        method         = new Method(new Type("integer"), "foobar", 3);
    LocalVariable localVariable  = new LocalVariable(new Type("integer"), "foobar", 0);

    table.put(method);
    table.enterNewFrame();
    table.put(localVariable);

    Method found = table.findMethod("foobar");
    assertEquals(method, found);
  }
}
