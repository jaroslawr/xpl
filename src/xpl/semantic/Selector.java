package xpl.semantic;

/**
 * An interface for a predicate deciding whether to include an element
 * in some form of a query
 *
 * @author Jarosław Rzeszótko
 */

public interface Selector<E> {
  public boolean select(E e);
}
