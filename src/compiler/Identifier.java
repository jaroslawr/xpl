public abstract class Identifier extends Symbol {
  public Identifier(Type type, String name) {
    super(name);
    this.type = type;
  }

  private Type   type;
  public  Type   getType()       { return type; }
  public  String typeSignature() { return type.getSignature(); }
}
