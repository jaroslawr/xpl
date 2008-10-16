public class Argument extends Variable {
  private int id;
  public  int getId() { return id; }

  public Argument(Type type, String name, int id) {
    super(type, name);
    this.id = id;
  }
}
