public abstract class Variable extends Symbol {
  private static String type = "variable";
  public boolean isOfType(String type) { return super.isOfType(type) || this.type.equals(type); }
}
