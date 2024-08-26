package bishi.mihoyo;

import java.util.*;

/**
 * @author daiYang_wu
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int res = 0;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>(m);
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            int type = in.nextInt();
            if (!map.containsKey(type)) {
                PriorityQueue<Integer> q = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
                q.add(v);
                map.put(type, q);
            } else {
                map.get(type).add(v);
            }
        }
        for (int i = 1; i <= m; i++) {
            res += map.get(i).poll();
        }
        for (int i = 1; i <= k - m; i++) {
            int max = Integer.MIN_VALUE;
            int t = 0;
            for (int j = 1; j <= m; j++) {
                if (map.get(j).size() == 0) continue;
                if (map.get(j).peek() > max) {
                    max = map.get(j).peek();
                    t = j;
                }
            }
            res += map.get(t).poll();
        }
        System.out.println(res);
    }
}
