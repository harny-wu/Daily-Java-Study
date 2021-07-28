package cn.daidai.alg.cache;

import java.util.HashMap;

/**
 * The least Recently used
 */
public class LRU<K, V> {
    private int cacheCapcity;
    Entry<K, V> head;
    Entry<K, V> tail;

    public LRU(int cacheCapcity) {
        this.cacheCapcity = cacheCapcity;
        cacheMap = new HashMap<>(cacheCapcity);
    }

    public int size(){
        return this.cacheMap.size();
    }

    class Entry<K, V> {
        Entry<K, V> next;
        Entry<K, V> prev;
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<K, Entry> cacheMap;

    public void put(K key, V value) {
        Entry<K, V> entrynode = cacheMap.get(key);
        if (entrynode == null) {
            if (cacheMap.size() >= cacheCapcity) {
                cacheMap.remove(tail.key);
                this.removeLast();
            }
            entrynode = new Entry<>(key, value);
            moveToFirst(entrynode);
        }
        entrynode.value = value;
        cacheMap.put(key, entrynode);
        moveToFirst(entrynode);
    }

    public V get(Object key) {
        Entry<K, V> entry = cacheMap.get(key);
        if (entry == null) {
            return null;
        }
        moveToFirst(entry);
        return entry.value;
    }

    public void moveToFirst(Entry entry) {
        if (head == null || tail == null) {
            head = tail = entry;
            return;
        }
        if (entry == head) {
            return;
        }
        if (entry == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        if (entry.prev != null) {
            entry.prev.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.prev = entry.prev;
        }
        entry.next = head;
        head.prev = entry;
        head = entry;
        entry.prev = null;
    }

    public void removeLast() {
        System.out.println("removelast："+tail.value);
        if (tail != null) {
            tail = tail.prev;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry node = head;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.value));
            node = node.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LRU<String, String> lruCache = new LRU<>(5);
        lruCache.put("001", "用户1信息");
        lruCache.put("002", "用户2信息");
        lruCache.put("003", "用户3信息");
        lruCache.put("004", "用户4信息");
        lruCache.put("005", "用户5信息");
        lruCache.get("002");
        lruCache.put("004", "用户2信息更新");
        lruCache.put("006", "用户6信息");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
        System.out.println(lruCache.toString());
        System.out.println(lruCache.size());

    }
}
