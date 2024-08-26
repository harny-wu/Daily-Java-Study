package leetcode.byteTop;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author daiYang_wu
 * 两两交换链表
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class swapPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] strNums = line.split(" ");
            int[] nums = Arrays.stream(strNums).mapToInt(Integer::parseInt).toArray();
            Node head = initList(nums);
            printList(head);
            head = swapPairs(head);
            printList(head);
        }
    }

    public static Node initList(int[] nums) {
        Node head = new Node(nums[0]);
        Node dummy = new Node(-1);
        dummy.next = head;
        for (int i = 1; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            head.next = node;
            head = node;
        }
        return dummy.next;
    }


    public static Node swapPairs(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node temp = dummy;
        /*
         * 1->2->3->4
         * temp->1->2->3->4
         *       s  e
         */
        // temp.next == null, 当前到了最后一个节点 , temp.next.next == null, 只有一个节点，不需要翻转

        while (temp.next != null && temp.next.next != null) {
            Node start = temp.next;
            Node end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;

        }
        return dummy.next;
    }

    public static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
