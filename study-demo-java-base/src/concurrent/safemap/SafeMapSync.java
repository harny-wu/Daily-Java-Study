package concurrent.safemap;

import java.util.HashMap;

public class SafeMapSync<K, V> extends HashMap<K, V> {
    static SafeMapSync<Integer, Integer> map = new SafeMapSync<>();

    @Override
    public synchronized V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public synchronized V get(Object key) {
        return super.get(key);
    }

    public static void main(String[] args) {

    }
}
