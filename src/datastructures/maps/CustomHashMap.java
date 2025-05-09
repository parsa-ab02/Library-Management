package datastructures.maps;

import datastructures.interfaces.Map;
import java.util.LinkedList;

public class CustomHashMap<K, V> implements Map<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;

    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(Object key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) throw new NullPointerException();
        int index = getBucketIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
        return null;
    }

    @Override
    public V get(Object key) {
        if (key == null) throw new NullPointerException();
        int index = getBucketIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) return entry.value;
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) throw new NullPointerException();
        int index = getBucketIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) return true;
        }
        return false;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }
}
