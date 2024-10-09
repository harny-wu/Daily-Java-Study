package xunlei;

import java.util.*;

public class Exam3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int [][] seq = new int [n][2];
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>(k);
        for (int i = 0 ; i < n; i++) {
            seq[i][0] = in.nextInt();
            seq[i][1] = in.nextInt();
            if (map.get(seq[i][1]) == null) {
                PriorityQueue<Integer> q = new PriorityQueue<>();
                q.add(seq[i][0]);
            }
        }
    }

}
