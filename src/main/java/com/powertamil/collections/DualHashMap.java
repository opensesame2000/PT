/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since   26-05-2018
 */
package com.powertamil.collections;

import java.util.*;

public class DualHashMap<K, V> extends HashMap<K, V> {

    private static final long serialVersionUID = 1L;
    Map<V, K> TACEToUTF8Map = new HashMap<>();

    //Loads forward and reverse maps
    @Override
    public V put(K key, V value) {
        if (TACEToUTF8Map.get(value) == null) {
            TACEToUTF8Map.put(value, key);
        }
        return super.put(key, value);
    }

    //Uses reverse map internally to getKey
    public K getKey(V value) {
        return TACEToUTF8Map.get(value);
    }

}
