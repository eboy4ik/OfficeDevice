package ru.rsreu.golyashhuk.datastructure;

import java.util.HashMap;
import java.util.Map;

public class DoubleSideMap<K, V> {
    Map<K, V> forwardMap = new HashMap<>();
    Map<V, K> backMap = new HashMap<>();

    public void put(K key, V value) {
        forwardMap.put(key, value);
        backMap.put(value, key);
    }

    public K getKey(Object value) {
        return backMap.get(value);
    }

    public V getValue(Object key) {
        return forwardMap.get(key);
    }


}
