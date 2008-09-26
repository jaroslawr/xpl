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
}
