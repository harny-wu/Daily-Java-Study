package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LRUCache
 * n = 2
 * Put 1 put 2 get 1 put 3
 */
public class LRUCache {

    public static class Node {
        public int key;
        public int value;

        public Node pre;

        public Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    private int cap;
    private Node head;
    private Node tail;

    private Map<Integer, Node> map;

    public LRUCache(int cap) {
        this.cap = cap;
        this.head = new Node();
        this.tail = new Node();
        this.map = new HashMap<>(cap);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = this.map.get(key);
        if (node == null) return -1;
        //删除节点，移到最前面
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (map.size() == this.cap) {
                this.map.remove(this.tail.pre.key);
                //删除最后一个
                removeNode(this.tail.pre);
                addToHead(node);
            } else {
                addToHead(node);
            }
            this.map.put(key, node);
        } else {
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }

    public void addToHead(Node node) {
        this.head.next.pre = node;
        node.next = this.head.next;
        this.head.next = node;
        node.pre = this.head;
    }

    public void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public void tostring(){
        Node temp = this.head.next;
        while(temp!=null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.tostring();
        cache.put(2,2);
        cache.tostring();
        cache.get(1);
        cache.tostring();
        cache.put(3,3);
        cache.tostring();

    }
}
