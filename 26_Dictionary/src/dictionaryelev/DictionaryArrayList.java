package dictionaryelev;

import java.util.ArrayList;

public class DictionaryArrayList<K, V> implements Dictionary<K, V> {
    private final ArrayList<Entry<K, V>>[] buckets;
    private static int N = 10;
    private int size;

    public DictionaryArrayList() {
        buckets = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            buckets[i] = new ArrayList<>();
        }
        size = 0;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        ArrayList<Entry<K, V>> bucket = buckets[index];
        V value = null;
        int i = 0;
        while (value == null && i < bucket.size()) {
            Entry<K, V> current = bucket.get(i);
            if (current.key.equals(key)) {
                value = current.value;
            }
            i++;
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        ArrayList<Entry<K, V>> bucket = buckets[index];
        V oldValue = findAndReplace(bucket, key, value);
        if (oldValue == null) {
            Entry<K, V> entry = new Entry<>(key, value);
            bucket.add(entry);
            size++;
        }
        return oldValue;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        ArrayList<Entry<K, V>> bucket = buckets[index];
        V removedValue = null;
        int i = 0;
        while (removedValue == null && i < bucket.size()) {
            Entry<K, V> current = bucket.get(i);
            if (current.key.equals(key)) {
                removedValue = current.value;
                bucket.remove(i);
                size--;
            }
            i++;
        }
        return removedValue;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Get the index of the bucket for the given key.
     * @param key the key to get the index for
     * @return the index of the bucket for the given key
     */
    private int getIndex(K key) {
        return key.hashCode() % N;
    }

    /**
     * Find the entry in a given bucket with the given key
     * and replace its value with the given value.
     * If the key exists the old value is returned, otherwise null is returned.
     * @param bucket the bucket to search in
     * @param key the key to search for
     * @param value the new value for the key
     * @return the old value if the key exists, otherwise null
     */
    private V findAndReplace(ArrayList<Entry<K, V>> bucket, K key, V value) {
        V oldValue = null;
        int i = 0;
        while (oldValue == null && i < bucket.size()) {
            Entry<K, V> current = bucket.get(i);
            if (current.key.equals(key)) {
                oldValue = current.value;
                current.value = value;
            }
            i++;
        }
        return oldValue;
    }

    private static class Entry<K, V> {
        public K key;
        public V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
