package xpl.semantic;

import xpl.semantic.symbols.*;

import java.util.*;

/**
 * The symbol table is used during semantic analysis to store
 * informations about encountered symbols, and provide you with those
 * informations later on when you're encountering the symbols defined
 * previously. Currently it uses a linked list of Frames for storing
 * symbols, through another approach will be needed for implementing
 * method overloading.
 *
 * @author Jarosław Rzeszótko
 */

public class SymbolTable {
  /**
   * Creates a new symbol table populated with the globally available
   * methods from the Runtime class
   */
  public SymbolTable() {
    enterNewFrame();

    current.put("puts",  new Method(Types.Void,    "puts",  new Type[] { Types.String  }, true));
    current.put("print", new Method(Types.Void,    "print", new Type[] { Types.Integer }, true));
    current.put("power", new Method(Types.Integer, "power", new Type[] { Types.Integer, Types.Integer }, true));
  }

  private ArrayList<Frame> frames = new ArrayList<Frame>();
  public int getCurrentFrameId() { return frames.size()-1; }

  private Frame current = null;

  /**
   * Find an Identifier symbol, meaning either a (method) Argument or a
   * Variable, in the current scope
   *
   * @param name The name of the identifier
   */
  public Identifier findIdentifier(String name) {
    return current.find(name, Identifier.class);
  }

  /**
   * Find an Argument symbol
   *
   * @param name The name of the argument
   */
  public Argument findArgument(String name) {
    return current.find(name, Argument.class);
  }

  /**
   * Find a Variable symbol
   *
   * @param name The name of the variable
   */
  public Variable findVariable(String name) {
    return current.find(name, Variable.class);
  }

  /**
   * Find a Method symbol
   *
   * @param name The name of the variable
   */
  public Method findMethod(String name) {
    return current.find(name, Method.class);
  }


  /**
   * Put a new symbol in the current frame
   *
   * @param sym The new symbol
   */
  public void put(Symbol sym) {
    current.put(sym.getName(), sym);
  }

  /**
   * Creates a new frame with the current frame as it parent and makes
   * it the new current frame.
   */
  public void enterNewFrame() {
    current = new Frame(current);
    frames.add(current);
  }

  /**
   * Makes the parent of the current frame the new current frame
   */
  public void exitFrame()  {
    current = current.getParent();
  }

  public String toString() {
    return current.toString();
  }
}
