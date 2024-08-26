package bishi.tengxun;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daiYang_wu
 */
public class LRU {
    public static class DNode {
        DNode next;
        DNode prev;
        int key;
        int val;

        public DNode() {
        }

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DNode head;
    DNode tail;
    Map<Integer, DNode> map;
    int size;
    int cap;

    public LRU(int cap) {
        this.cap = cap;
        size = 0;
        map = new HashMap<>(cap);
        head = new DNode(0,0);
        tail = new DNode(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (this.map.get(key) == null) return -1;
        DNode node = this.map.get(key);
        // 删除当前node
        removeNode(node);
        // 添加到前面
        addToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        // 如果不在缓存中
        if (this.map.get(key) == null) {
            DNode node = new DNode(key, val);
            if (cap == size) {
                //缓存已满
                this.map.remove(this.tail.prev.key); //map 同时删除
                removeNode(this.tail.prev); // 删除最后一个节点
                this.size--;
                addToHead(node);
                this.map.put(key, node);
            } else {
                // 缓存未满
                this.map.put(key, node);
                addToHead(node);
            }
            this.size++;
        } else { //在缓存中
            DNode node = this.map.get(key);
            node.val = val;
            // 删除当前node
            removeNode(node);
            // 添加到前面
            addToHead(node);
        }
    }

    public void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public void addToHead(DNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void printList() {
        DNode temp = head;
        System.out.println(String.format("begin: capacity = %s, size = %s",cap,size));
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.printList();
        cache.put(2, 2);
        cache.printList();
        cache.put(3, 3); // 该操作会使得关键字 2 作废
        cache.printList();
        cache.get(2); // 返回 -1 (未找到)
        cache.printList();
        cache.put(4, 4); // 该操作会使得关键字 1 作废
        cache.printList();
        cache.get(1); // 返回 -1 (未找到)
        cache.printList();
        cache.get(3); // 返回 3
        cache.printList();
        cache.get(4); // 返回 4
        cache.printList();

    }
}
