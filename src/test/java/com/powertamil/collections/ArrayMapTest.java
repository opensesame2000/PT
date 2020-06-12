package com.powertamil.collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.powertamil.collections.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Tests the ArrayMap class by running it through some standard
 * map operations.
 *
 * @author John Bauer
 */
public class ArrayMapTest {
    ArrayMap<String, String> map;
    HashMap<String, String> hmap;

    public void setUp() {
        map = new ArrayMap<String, String>();
        hmap = new HashMap<String, String>();

        map.put("Foo", "SUN");
        map.put("Bar", "MOON");
        map.put("Baz", "VENUS");

        hmap.put("Foo", "SUN");
        hmap.put("Bar", "MOON");
        hmap.put("Baz", "VENUS");
    }

    @Test
    public void testEquals() {
        assertEquals(map, map);
        assertTrue(true);
        assertEquals(map, hmap);
        assertEquals(hmap, map);
    }

    @Test
    public void testClear() {
        assertTrue(map.isEmpty());
        map.clear();
        assertTrue(map.isEmpty());
        map.put("aaa", "5");
        assertEquals(1, map.size());
    }

    @Test
    public void testPutAll() {
        map.clear();
        assertTrue(map.isEmpty());
        map.putAll(hmap);
        testEquals();
        HashMap<String, String> newmap = new HashMap<>();
        newmap.putAll(map);
        assertEquals(newmap, map);
        assertEquals(map, newmap);
    }

    @Test
    public void testEntrySet() {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Map.Entry<String, String> entry = entries.iterator().next();
        entries.remove(entry);
        assertFalse(map.containsKey(entry.getKey()));
        assertEquals(2, map.size());
        entries.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void testValues() {
        Set<String> hmapValues = new HashSet<>();
        hmapValues.addAll(hmap.values());

        Set<String> mapValues = new HashSet<>();
        mapValues.addAll(map.values());

        assertEquals(hmapValues, mapValues);
    }

    @Test
    public void testPutDuplicateValues() {
        map.clear();
        map.put("Foo", "STAR");
        assertEquals("STAR", map.get("Foo"));
        assertEquals(1, map.size());
        map.put("Foo", "GALAXY");
        assertEquals("GALAXY", map.get("Foo"));
        assertEquals(1, map.size());
    }
}