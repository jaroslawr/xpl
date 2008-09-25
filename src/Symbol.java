public abstract class Symbol {
  protected String name;

  private static String type = "symbol";
  public boolean isOfType(String type) { return this.type.equals(type); }

  public Symbol() {}

  public Symbol(String name) {
    this.name = name;
  }
}
