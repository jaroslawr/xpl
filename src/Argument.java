public class Argument extends Variable {
  private static String type = "argument";
  public boolean isOfType(String type) { return super.isOfType(type) || this.type.equals(type); }

  private int id;
  public  int getId() { return id; }

  public Argument(String name, int id) {
    this.name = name;
    this.id   = id;
  }
}
