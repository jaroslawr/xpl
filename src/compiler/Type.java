public class Type {
  public Type(String name) {
    this.name = name;
  }

  public boolean equals(Type type) {
    return this.name.equals(type.name);
  }

  private String name;
  public  String getName() { return name; }

  public String getSignature() {
    if(name == "integer")
      return "I";

    if(name == "string")
      return "Ljava/lang/String;";

    if(name == "void")
      return "V";

    return null;
  }

  public String toString() {
    return name;
  }
}
