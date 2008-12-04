package xpl.semantic;

import java.util.*;

import xpl.semantic.Selector;

/**
 * A multimap keeping the insertion order under each key
 *
 * @author Jarosław Rzeszótko
 */
public class HashMultiMap<K, V> {
  private HashMap<K, List<V>> entries = new HashMap<K, List<V>>();

  /**
   * Inserts an element into the map
   *
   * @param key The key to insert under
   * @param value The value to associate the given key with
   */
  public void put(K key, V value) {
    if(!entries.containsKey(key))
      entries.put(key, new LinkedList<V>());

    List<V> values = entries.get(key);
    values.add(value);
  }

  /**
   * Returns the first element matching the predicate defined by
   * Selector.select, beginning the lookup from the last entry
   * inserted for a given key and going backwards.
   *
   * @param key The key in the map to run the search in
   * @param selector The selector to use for the predicate to matching the item against
   */
  public V get(String key, Selector<V> selector) {
    List<V> values = entries.get(key);
    if(values == null) return null;
    for (ListIterator<V> it = values.listIterator(values.size()); it.hasPrevious();) {
      V value = it.previous();
      if(selector.select(value))
	 return value;
    }
    return null;
  }

  /**
   * Returns all elements matching the predicate defined by
   * Selector.select in inverse insertion order
   *
   * @param key The key in the map to run the search in
   * @param selector The selector to use for the predicate to matching the item against
   */
  public List<V> getAll(String key, Selector<V> selector) {
    List<V> values = entries.get(key);
    List<V> result = new ArrayList<V>();
    for (ListIterator<V> it = values.listIterator(values.size()); it.hasPrevious();) {
      V value = it.previous();
      if(selector.select(value))
	result.add(value);
    }
    return result;
  }

  public String toString() {
    return entries.toString();
  }
}
