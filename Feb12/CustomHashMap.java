package Feb12;

import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private static final int SIZE = 16; // Default size of the hash map
    private LinkedList<Entry<K, V>>[] buckets;

    static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }
        
        bucket.add(new Entry<>(key, value)); // Insert new key-value pair
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        
        return null; // Key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            LinkedList<Entry<K, V>> bucket = buckets[i];
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : bucket) {
                    System.out.print("[" + entry.key + " -> " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        
        System.out.println("Value for 'two': " + map.get("two")); // Output: 2
        
        map.put("two", 22); // Update the value for 'two'
        System.out.println("Updated value for 'two': " + map.get("two")); // Output: 22
        
        map.remove("one");
        System.out.println("Value for 'one': " + map.get("one")); // Output: null
        
        map.print(); // Prints the remaining key-value pairs
    }
}
