package xpl.semantic;

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
    if(name.equals("real"))
      return "D";
    
    if(name.equals("integer"))
      return "I";

    if(name.equals("string"))
      return "Ljava/lang/String;";

    if(name.equals("void"))
      return "V";

    return null;
  }

  public String toString() {
    return name;
  }
}
