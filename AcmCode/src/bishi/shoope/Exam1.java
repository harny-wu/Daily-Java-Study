package bishi.shoope;

/**
 * @author daiYang_wu
 */
public class Exam1 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode Rotate(ListNode head, int k) {
        // write code here
        int n = count(head);
        ListNode newHead = reverse(head);
        ListNode temp = newHead;
        for (int i = 1; i < k % n; i++) temp = temp.next;
        ListNode lastHead = temp.next;
        temp.next = null;
        newHead = reverse(newHead);
        lastHead = reverse(lastHead);
        ListNode curr = newHead;
        while (curr.next != null) curr = curr.next;
        curr.next = lastHead;
        return newHead;

    }

    public static int count(ListNode head) {
        int res = 1;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            res++;
        }
        return res;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
