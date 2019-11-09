package lfu_cache;

import java.util.*;

public class LFUCache<K, V> implements Iterable<V>{
    private int size;
    private TreeMap<Integer, List<Node<K, V>>> countMap = null;
    private HashMap<K, Node<K, V>> cache = null;

    private class Node<K, V> {
        K key;
        V value;
        int count;

        Node (K key, V value) {
            this.key = key;
            this.value = value;
        }

        Node (K key, V value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    LFUCache(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("invalid size");
        }
        cache = new HashMap<K, Node<K, V>>(size);
        countMap = new TreeMap<Integer, List<Node<K,V>>>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        this.size = size;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            int count = node.getCount();
            node.setCount(count + 1);

            rmCountNode(count, node);
            addCountNode(count + 1, node);
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        addCountNode(node.getCount(), node);

        if (cache.size() == size + 1) {
            Map.Entry<Integer, List<Node<K, V>>> entry = countMap.firstEntry();
            Node node1 = entry.getValue().get(0);
            rmCountNode(node1.getCount(), node1);
            cache.remove(node1.getKey());
        }
    }

    public V get(K key) {
        if (!cache.containsKey(key))
            return  null;

        Node<K, V> node = cache.get(key);
        rmCountNode(node.getCount(), node);
        addCountNode(node.getCount() + 1, node);
        node.setCount(node.getCount() + 1);

        return node.getValue();
    }

    private void addCountNode (int count, Node<K, V> node) {
        List<Node<K, V>> list = countMap.get(count);
        if (null == list) {
            list = new ArrayList<Node<K, V>>();
            countMap.put(count, list);
        }
        list.add(node);
    }

    private void rmCountNode(int count, Node<K, V> node) {
        List<Node<K, V>> list = countMap.get(count);
        if (list.size() == 1) {
            countMap.remove(count);
        } else {
            list.remove(node);
        }
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
                return it.next().getValue().getValue();
            }
        };
    }

    public static void main(String[] args) {
        LFUCache<Integer, Integer> cache = new LFUCache<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(4, 5);
        cache.get(3);
        cache.get(3);
        cache.get(3);
        cache.put(5, 10);
        cache.put(9, 9);

//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
//        System.out.println(cache.get(4));

        Iterator<Integer> it = cache.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
