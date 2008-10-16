public abstract class Variable extends Symbol {
  private Type type;
  public  Type getType() { return type; }

  public Variable(Type type, String name) {
    super(name);
    this.type = type;
  }
}
