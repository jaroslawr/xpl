public class Method extends Symbol {
  private static String type = "method";
  public boolean isOfType(String type) { return super.isOfType(type) || this.type.equals(type); }

  private int arity;
  public  int getArity() { return arity; }

  private String signature;

  public Method(String name, int arity) {
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
