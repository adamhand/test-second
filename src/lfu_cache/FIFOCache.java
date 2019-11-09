package lfu_cache;

import java.util.*;

public class FIFOCache <K, V> implements Iterable<V> {
    private int size;
    private HashMap<K, Node<K, V>> cache;
    private Queue<K> queue;

    private class Node <K, V> {
        K key;
        V value;

        Node (K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    FIFOCache (int size) {
        if (size < 0) {
            throw new IllegalArgumentException("invalid size");
        }

        this.size = size;
        cache = new HashMap<>(size);
        queue = new LinkedList<>();
    }

    public void put (K key, V value) {
        if (cache.containsKey(key)) {
            queue.remove(key);
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        queue.add(key);

        if (cache.size() == size + 1) {
            K k = queue.poll();
            queue.remove(k);
            cache.remove(k);
        }
    }

    public V get (K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        return cache.get(key).value;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private Iterator<Map.Entry<K, Node<K, V>>> it = cache.entrySet().iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public V next() {
                return it.next().getValue().value;
            }
        };
    }

    public static void main(String[] args) {
        FIFOCache<Integer, Integer> cache = new FIFOCache(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.put(5, 9);

        for (Integer v : cache) {
            System.out.print(v + " ");
        }
    }
}
