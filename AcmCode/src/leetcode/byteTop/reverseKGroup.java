package leetcode.byteTop;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author daiYang_wu
 * K 个反转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/solutions/10416/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 */
public class reverseKGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] strNums = line.split(" ");
            int[] nums = Arrays.stream(strNums).mapToInt(Integer::parseInt).toArray();
            Node head = Node.initList(nums);
            Node.printList(head);
            head = reverseKGroup(head,3);
            Node.printList(head);
        }
    }

    public static Node reverseKGroup(Node head,int k) {
        if (k <= 1 ) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pre = dummy;
        Node end = dummy;
        while (end.next != null){
            for (int i = 0; i < k ; i++) {
                if (end == null) break;
                end = end.next;
            }
            Node start = pre.next;
            Node next = end.next;
            end.next = null;
            pre.next = reverseList(start);
            Node.printList(dummy.next);
            start.next = next;

            pre = start;
            end = pre;
        }
        return dummy.next;
    }


    public static Node reverseList(Node head){
        Node prev = null;
        while(head!=null){
            Node temp = head.next;
            head.next = prev; //只改变一条线
            prev = head;
            head = temp;
        }
        return prev;
    }
}
