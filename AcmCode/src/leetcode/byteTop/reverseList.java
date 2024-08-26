package leetcode.byteTop;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author daiYang_wu
 * https://leetcode.cn/problems/reverse-linked-list/
 * 反转列表
 */
public class reverseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] strNums = line.split(" ");
            int[] nums = Arrays.stream(strNums).mapToInt(Integer::parseInt).toArray();
            Node head = Node.initList(nums);
            Node.printList(head);
            head = reverseList(head);
            Node.printList(head);
        }
    }

    public static Node reverseList(Node head){
        Node prev = null;
        // 1->2->3->4
        //
        while(head!= null){
            Node temp = head.next; // 合理使用temp
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }



}
