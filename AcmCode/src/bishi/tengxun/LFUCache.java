package bishi.tengxun;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author daiYang_wu
 */
public class LFUCache {

    Queue<Node> queue;
    Map<Integer, Node> map;
    int cap;
    int index = 1;

    public LFUCache(int cap) {
        this.cap = cap;
        this.queue = new PriorityQueue<>(cap);
        this.map = new HashMap<>(cap);
    }

    public int get(int key) {
        Node node = this.map.get(key);
        if (node == null) return -1;
        node.index = this.index++;
        node.freq++;
        this.queue.remove(node);
        this.queue.offer(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = this.map.get(key);
        if (node != null) {
            node.index = this.index++;
            node.freq++;
            this.queue.remove(node);
            this.queue.offer(node);
        }else {
            Node newNode = new Node(key,val,this.index++);
            if (this.queue.size() == cap){
                //删除最少访问
                this.map.remove(this.queue.poll());
            }
            this.queue.offer(newNode);
            this.map.put(key,newNode);
        }
    }

    public class Node implements Comparable<Node> {
        int key;
        int val;
        int index;
        int freq = 0;

        public Node(int key, int val, int index) {
            this.key = key;
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            int min = this.freq - o.freq;
            return min == 0 ? this.index - o.index : min;
        }


    }
}
