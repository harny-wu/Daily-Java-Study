package leetcode.byteTop;

/**
 * @author daiYang_wu
 */
public class Node {
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
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


    public static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
