public abstract class Symbol {
  protected String name;
  public String getName() { return name; }

  public Symbol() {}

  public Symbol(String name) {
    this.name = name;
  }
}
