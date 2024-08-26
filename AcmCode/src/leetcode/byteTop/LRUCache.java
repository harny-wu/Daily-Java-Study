package leetcode.byteTop;

import java.util.*;

/**
 * @author daiYang_wu
 * https://leetcode.cn/problems/lru-cache/description/
 * bishi.tengxun.LRU last recent use : 最近最少使用
 * 双向链表 + HashMap
 * put : 添加到队尾, 并将引用放到HashMap里, 判断是否超过容量，超过的话删除队尾元素
 * get: 通过HashMap 获得引用，返回value, 从链表中删除，并放到队尾
 */
public class LRUCache {
    // 双向节点
    static class DNode {
        DNode prev;
        DNode next;
        int key;
        int val;

        DNode() {
        }

        DNode(int val) {
            this.val = val;
        }

        DNode(int key, int val) {
            this.val = val;
            this.key = key;
        }

        public String toString() {
            return this.key + ":" + this.val;
        }
    }

    private int capacity;
    private Map<Integer, DNode> map;
    private DNode tail;
    private DNode head;


    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.tail = new DNode();
        this.head = new DNode();
        head.next = tail; // head 和 prev是dummy 节点
        tail.prev = head;
    }

    public int size() {
        return this.map.size();
    }

    public int get(int key) {
        DNode node = this.map.get(key);
        if (node == null) return -1; // 注意判空
        // 1. 删除当前node
        removeNode(node);
        // 2. 添加到头部
        addToHead(node);

        // 或则 moveToHead()
        return node.val;
    }

    public void put(int key, int value) {
        DNode node = this.map.get(key);

        // 更新值 并移到头部
        if (node != null) {
            node.val = value;
            this.moveToHead(node);
            return;
        }

        node = new DNode(key, value);
        if (capacity == size()) {
            this.map.remove(this.tail.prev.key);
            removeLast();
        }
        addToHead(node);
        this.map.put(key, node);
    }

    public void moveToHead(DNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DNode node) {
        // 双向链表方便删除,O(1)
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(DNode node) {

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }

    public void removeLast() {
        removeNode(this.tail.prev);
    }

    public void printList() {
        DNode temp = head;
        System.out.println(String.format("begin: capacity = %s, size = %s",capacity,this.map.size() ));
        while (temp != null) {
            System.out.print(temp.toString() + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        // put 1 put 2 get 1 put 3

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.printList();
        cache.put(2, 2);
        cache.printList();
        cache.get(1);
        cache.put(3, 3);
        cache.printList();
        cache.get(2);
        cache.printList();
        cache.put(4, 4);
        cache.printList();
        cache.get(1);
        cache.printList();
        cache.get(3);
        cache.printList();
        cache.get(4);
        cache.printList();

//        Scanner sc = new Scanner(System.in);
//
//        while(sc.hasNextLine()){
//            String str = sc.nextLine();
//            String[] operate = convertInput(str);
//            System.out.println(Arrays.toString(operate));
//            LRUCache cache = new LRUCache(10);
//        }
    }

    public static String[] convertInput(String str) {
        str = "[\"LRUCache\", \"put\", \"put\", \"get\", \"put\", \"get\", \"put\", \"get\", \"get\", \"get\"]";
        String[] res = str.substring(1, str.length() - 1).split(", ");
        for (String s : res) {
            s.replace("\"", "");
        }
        return res;
    }



}
