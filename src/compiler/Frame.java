import java.util.*;

public class Frame {
  public Frame(Frame parent) { this.parent = parent; }

  private Frame parent = null;
  public  Frame getParent() { return parent; }

  private Hashtable<String, Symbol> symbols = new Hashtable<String, Symbol>();

  <T extends Symbol> T put(String name, T symbol) {
    symbols.put(name, symbol);
    return symbol;
  }

  public <T extends Symbol> T find(String name, Class<T> kind) {
    Symbol sym = symbols.get(name);
    if(sym != null && kind.isInstance(sym))
      return kind.cast(sym);
    return parent == null ? null : parent.find(name, kind);
  }

  public String toString() {
    return symbols.toString() + "\n" + (parent == null ? "" : parent.toString());
  }
}
