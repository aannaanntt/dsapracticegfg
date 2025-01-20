package linkedlist.gfg;
import java.util.LinkedHashSet;

class LRUCache {
    private final int capacity; // Maximum capacity of the cache
    private LinkedHashSet<Integer> cache; // To store the keys in LRU order

    // Constructor to initialize the cache with a given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashSet<>(capacity);
    }

    // Get method to access an item
    public boolean get(int key) {
        if (!cache.contains(key)) {
            return false; // Key not found in the cache
        }
        // Key exists; move it to the end (most recently used)
        cache.remove(key);
        cache.add(key);
        return true;
    }

    // Put method to add or update an item
    public void put(int key) {
        if (cache.contains(key)) {
            // If key exists, remove it first to update its position
            cache.remove(key);
        } else if (cache.size() == capacity) {
            // Cache is full; remove the least recently used item (first item)
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        // Add the key as the most recently used
        cache.add(key);
    }

    // Display the current state of the cache
    public void display() {
        System.out.println(cache);
    }

    public static void main(String[] args) {
        // Create an LRU Cache with capacity 3
        LRUCache lru = new LRUCache(3);

        lru.put(1);
        lru.put(2);
        lru.put(3);
        lru.display(); // Output: [1, 2, 3]

        lru.get(2); // Access 2 (now 2 becomes most recently used)
        lru.display(); // Output: [1, 3, 2]

        lru.put(4); // Add 4 (1 will be removed as it's least recently used)
        lru.display(); // Output: [3, 2, 4]

        lru.get(1); // Try to access 1 (not present in the cache)
        System.out.println(lru.get(1)); // Output: false

        lru.put(5); // Add 5 (3 will be removed as it's least recently used)
        lru.display(); // Output: [2, 4, 5]
    }
}
