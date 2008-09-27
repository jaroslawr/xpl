import org.junit.*;
import static org.junit.Assert.*;

public class ScopeTest {
  @Test
  public void storesArguments() {
    Scope scope = new Scope(null);
    scope.addArgument("foobar");

    Argument arg = scope.findArgument("foobar");
    assertNotNull(arg);
  }

  @Test
  public void storesLocalVariables() {
    Scope scope = new Scope(null);
    scope.addLocalVariable("foobar");

    LocalVariable var = scope.findLocalVariable("foobar");
    assertNotNull(var);
  }

  @Test
  public void storesMethods() {
    Scope scope = new Scope(null);
    scope.addMethod("foobar", 3);

    Method method = scope.findMethod("foobar");
    assertNotNull(method);
    assertEquals(3, method.getArity());
  }

  @Test
  public void ignoresItemsOfDifferentTypeWhenLookingUpSymbols() {
    Scope parent = new Scope(null);
    parent.addMethod("foobar", 5);

    Scope child  = new Scope(parent);
    child.addLocalVariable("foobar");

    Method method = child.findMethod("foobar");
    assertNotNull(method);
    assertEquals(5, method.getArity());
  }

  @Test
  public void tracksArgumentsCount() {
    // "this" is the 0-th argument

    Scope parent = new Scope(null);
    parent.addArgument("a");

    Scope child  = new Scope(parent);
    child.addArgument("a");
    child.addArgument("b");

    assertEquals(2, parent.getArgumentsCount());
    assertEquals(3, child.getArgumentsCount());
  }
}
