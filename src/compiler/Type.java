public class Type {
  private String name;
  public  String getName() { return name; }

  public String signature() {
    if(name == "integer")
      return "I";

    if(name == "string")
      return "Ljava/lang/String;";

    return null;
  }

  public Type(String name) {
    this.name = name;
  }
}
