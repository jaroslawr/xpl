public abstract class Variable extends Symbol {
  private Type type;

  public  String typeSignature() { return type.signature(); }

  public Variable(Type type, String name) {
    super(name);
    this.type = type;
  }
}
