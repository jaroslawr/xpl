public class Method extends Symbol {
  private int arity;
  public  int getArity() { return arity; }

  private String signature;

  private Type type;

  public Method(Type type, String name, int arity) {
    this.type  = type;
    this.name  = name;
    this.arity = arity;

    generateSignature();
  }

  private void generateSignature() {
    signature = "(";
    for(int i = 0; i < arity; i++)
      signature += "I";
    signature += ")I";
  }

  public String getSignature() {
    return signature;
  }
}
