package baidu;

import java.util.Scanner;

/**
 * @author daiYang_wu
 */
public class Exam2 {
    public static class Node{
        char c;
        Node next;
        Node prev;
        public Node(){}
        public Node(char c){
            this.c = c;
        }
    }
    public static class LinkedString{
        Node head;
        Node tail;
        public LinkedString(String s){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            for (char c : s.toCharArray()){
                add(c);
            }
        }
        public void add(char c){
            Node node = new Node(c);
            this.tail.prev.next = node;
            node.prev = this.tail.prev;
            this.tail.prev = node;
            node.next = tail;
        }

        public void removeAndAddToTail(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;

            this.tail.prev.next = node;
            node.prev = this.tail.prev;
            this.tail.prev = node;
            node.next = tail;
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            Node curr = this.head.next;
            while (curr != tail){
                sb.append(curr.c);
                curr = curr.next;
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        LinkedString ls = new LinkedString(str);


        Node curr = ls.head.next;
        for (int i = 1; i < str.length();i++){
            Node next = curr.next.next;
            ls.removeAndAddToTail(curr);
            curr = next;
        }
        System.out.println(ls.toString());
    }
}
