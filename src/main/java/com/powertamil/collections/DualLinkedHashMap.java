/**
 * @author Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since 26-05-2018
 */
package com.powertamil.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class DualLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 1L;

    /**
     * LinkedHashMap differs from HashMap in that it maintains a doubly-linked
     * list running through all of its entries. This linked list defines the
     * iteration ordering, which is normally the order in which keys were inserted
     * into the map (insertion-order). Note that insertion order is not affected if
     * a key is re-inserted into the map.
     *
     * Insertion order preservation is a must to transform.
     */
    Map<V, K> encodedMap = new LinkedHashMap<>();

    //Loads forward and reverse maps
    @Override
    public V put(K key, V value) {
        if (encodedMap.get(value) == null) {
            encodedMap.put(value, key);
        }
        return super.put(key, value);
    }

    //Uses reverse map internally to getKey
    public K getKey(V value) {
        return encodedMap.get(value);
    }


}
