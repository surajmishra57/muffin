package org.example.lld_interview_problems.lrucache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> {
    private int capacity;
    private DoublyLinkList<K, V> ddl;
    private Map<K, Node<K, V>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.ddl = new DoublyLinkList<>();
        this.map = new ConcurrentHashMap<>();
    }

    public synchronized V get(K k) {
        if (!map.containsKey(k))
            return null;
        Node<K, V> node = map.get(k);
        ddl.moveToFirst(node);
        return node.value;
    }

    public synchronized void put(K k, V v) {
        if (map.containsKey(k)) {
            Node<K, V> node = map.get(k);
            node.value = v;
            ddl.moveToFirst(node);
        } else {
            if (capacity == map.size()) {
                Node<K, V> node = ddl.removeLast();
                if (node != null)
                    map.remove(node.key);
            }
            Node<K, V> node = new Node<>(k, v);
            ddl.addFirst(node);
            map.put(node.key, node);
        }
    }

    public synchronized void remove(K key) {
        if (!map.containsKey(key))
            return;
        Node<K, V> node = map.get(key);
        ddl.remove(node);
        map.remove(node.key);
    }
}
