package TME;

import sun.management.Agent;

import java.util.HashSet;
import java.util.List;

public class Exam2 {
    public static ListNode genList(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = genList(new int[]{1, 2, 2, 3, 4});
        System.out.println(a);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode mergeList(ListNode a, ListNode b) {
        // write code here
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (a.equals(b)) {
            curr.next = a;
            a = a.next;
            b = b.next;
            if (a.next == b.next) {
                curr = curr.next;
            }
        }
        // curr.next = findSecond(a, b);
        return dummy.next;
    }

    public ListNode findSecond(ListNode a, ListNode b) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = a;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = b;
        while (temp.next != null) {
            if (set.contains(temp.next)) {
                ListNode next = temp.next;
                temp.next = null;
                return next;
            }
            temp = temp.next;
        }
        return new ListNode(-1);
    }

}
