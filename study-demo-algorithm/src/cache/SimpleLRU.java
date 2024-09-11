package cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleLRU {
    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> cache;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    private int cap;

    public SimpleLRU(int cap) {
        this.cap = cap;
        this.cache = new HashMap<>(cap);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int val) {
        Node node = this.cache.get(key);
        if (node != null) {
            remove(node);
            moveToHead(node);
            node.val = val;
        } else {
            if (cache.size() == cap) {
                this.cache.remove(tail.prev.val);
                remove(tail.prev);
            }
            node = new Node(key, val);
            this.cache.put(key, node);

            moveToHead(node);

        }
    }

    public Integer get(int key) {
        Node node = this.cache.get(key);
        if (node == null) return -1;
        // 删除节点
        remove(node);
        // 移到最前
        moveToHead(node);

        return node.val;
    }

    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void moveToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }

    public void printList() {
        Node temp = head.next;
        StringBuilder sb = new StringBuilder();
        while (temp != tail) {
            sb.append(temp.val + "->");
            temp = temp.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        SimpleLRU lru = new SimpleLRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.printList();
        lru.get(1);
        lru.printList();
        lru.put(3, 3);
        lru.printList();
    }
}
