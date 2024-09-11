package concurrent.safemap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SafeMapWriteLock<K, V> {
    private Map<K, V> map;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public V get(K key) {
        lock.readLock().lock();
        try {
            return this.map.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void put(K key, V val){
        lock.writeLock().lock();
        try {
            this.map.put(key,val);
        }finally {
            lock.writeLock().unlock();
        }

    }
}
