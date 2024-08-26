package leetcode.byteTop;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 * <p>
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近 最少使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 * <p>
 * 示例：
 * <p>
 * bishi.tengxun.LFUCache cache = new bishi.tengxun.LFUCache( 2
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回 1
 * cache.put(3,3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4,4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lfu-cache
 *
 * @author daiYang_wu
 */
public class LFUCache {
    int index = 0;
    int cap;
    PriorityQueue<Node> cache;
    Map<Integer, Node> map;


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // 返回 1
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 去除 key 2
        // 返回 -1 (未找到key 2)
        System.out.println(cache.get(2));
        // 返回 3
        System.out.println(cache.get(3));
        cache.put(4, 4);    // 去除 key 1
        // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(1));
        // 返回 3
        System.out.println(cache.get(3));
        // 返回 4
        System.out.println(cache.get(4));
    }

    public LFUCache(int cap) {
        this.cache = new PriorityQueue<>(cap);
        this.map = new HashMap<>(cap);
        this.cap = cap;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        node.index++;
        node.freq++;
        // 每次都重新remove，再offer是为了让优先队列能够对当前Node重排序
        //不然的话，比较的 freq 和 index 就是不准确的
        this.cache.remove(node);
        this.cache.offer(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = this.map.get(key);
        if (node != null) {
            node.freq++;
            node.index++;
        }else{
            Node newNode = new Node(key, value, index++);
            if (this.cap == this.cache.size()){
                this.map.remove(this.cache.poll().key);
            }
            this.cache.offer(newNode);
            this.map.put(key,newNode);
        }
    }


    private static class Node implements Comparable<Node> {
        int key;
        int value;
        int index;
        int freq = 1;

        public Node(int key, int value, int index) {
            this.key = key;
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            int min = this.freq - o.freq;
            return min == 0 ? this.index - o.index : min;
        }
    }
}
