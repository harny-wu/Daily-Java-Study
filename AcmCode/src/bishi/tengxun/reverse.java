package bishi.tengxun;

import java.awt.*;

/**
 * @author daiYang_wu
 */
public class reverse {
    public static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

    public static Node initList(int[] nums) {
        Node dummy = new Node();
        Node head = new Node(nums[0]);
        dummy.next = head;
        for (int i = 1; i < nums.length; i++) {
            head.next = new Node(nums[i]);
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node list = initList(new int[]{1, 2, 3, 4, 5});
        printList(list);
        printList(reverse(list));
    }

    public static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.val + "->");
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr!= null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
