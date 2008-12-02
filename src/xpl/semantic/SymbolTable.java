package xpl.semantic;

import java.util.*;

import xpl.semantic.symbols.*;

/**
 * The symbol table is used during semantic analysis to store
 * informations about encountered symbols, and provide you with them
 * later on when you're encountering the symbols that were defined
 * previously. The current implemenation is loosely based on the
 * seminal paper by LeBlanc and Cook - "A Symbol Table Abstraction to
 * Implement Languages with Explicit Scope Control"
 *
 * @author Jarosław Rzeszótko
 */
public class SymbolTable {
  /**
   * Constructs an empty symbol table and populates it with the
   * globally available runtime methods
   */
  public SymbolTable() {
    enterScope();

    put(new Method(0, Types.Void,    "print", new Type[] { Types.String  }, true));
    put(new Method(0, Types.Void,    "print", new Type[] { Types.Integer }, true));
    put(new Method(0, Types.Integer, "power", new Type[] { Types.Integer, Types.Integer }, true));
  }

  /**
   * Creates a new scope and enters it
   * @param scopeId The id to give to the newly created scope
   */
  public void enterScope() {
    scopes.push(new Integer(++nextScopeId));
    currentScopeId = nextScopeId;
  }

  /**
   * Exits from the current scope, returning its id
   */
  public int exitScope() {
    currentScopeId--;
    return scopes.pop();
  }

  /**
   * Returns the id of the current scope.
   */
  public int getCurrentScopeId() {
    return currentScopeId;
  }

  /**
   * Returns the id that will be given to the next scope entered,
   * needed for symbol creation.
   */
  public int getNextScopeId() {
    return nextScopeId + 1;
  }

  /**
   * Add a symbol to the current scope
   *
   * @param symbol The symbol to add
   */
  public void put(Symbol symbol) {
    symbols.put(symbol.getName(), symbol);
  }

  /**
   * Finds the symbol represting the innermost definition of the given
   * identifier (representing an argument or local variable)
   *
   * @param name The name of the sought identifier
   */
  public Identifier findIdentifier(String name) {
    return (Identifier) symbols.get(name, symbolSelector.withType(Identifier.class));
  }

  /**
   * Finds the symbol represting the innermost definition of the given
   * method argument
   *
   * @param name The name of the argument
   */
  public Argument findArgument(String name) {
    return (Argument) symbols.get(name, symbolSelector.withType(Argument.class));
  }

  /**
   * Finds the symbol represting the innermost definition of the given
   * variable
   *
   * @param name The name of the variable
   */
  public Variable findVariable(String name) {
    return (Variable) symbols.get(name, symbolSelector.withType(Variable.class));
  }

  /**
   * Finds all methods with a given name and arity (the number of
   * parameters) returning them in a list, with the innermost
   * definition first
   *
   * @param name The name of the variable
   * @param arity The number of arguments of the looked up method
   */
  public List<Symbol> findMethods(String name, int arity) {
    return symbols.getAll(name, methodSelector.withArity(arity));
  }

  private Stack<Integer> scopes = new Stack<Integer>();

  private HashMultiMap<String, Symbol> symbols = new HashMultiMap<String, Symbol>();

  private VisibleSymbolSelector symbolSelector = new VisibleSymbolSelector(scopes);

  private VisibleMethodSelector methodSelector = new VisibleMethodSelector(scopes);

  private int nextScopeId = -1;
  private int currentScopeId = -1;
}
