package xunlei;

import java.util.*;

public class Exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int n = 0;
        while (sc.hasNext()) {
            int x = sc.nextInt();
            n++;
            map.put(x, map.getOrDefault(x, 0) + 1);

        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        System.out.println(Math.min(max + 3, n));
    }
}
