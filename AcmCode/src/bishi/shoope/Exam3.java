package bishi.shoope;

import java.util.*;

/**
 * @author daiYang_wu
 */
public class Exam3 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(2, 0);
        map.put(1, 1);
        map.put(3, 2);
        map.put(4, 3);
        map.put(5, 4);
        int n = 10;
        List<Integer> res = new ArrayList<>();
        for (Integer v : map.keySet()) {
            n = n - v;
            if (n < 0) break;
            res.add(map.get(v));
        }
        System.out.println(res.toString());
    }

    public int[] solution(int[] costs, int coins) {
        // write code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < costs.length; i++) map.put(costs[i], i);
        List<Integer> res = new ArrayList<>();
        for (Integer v : map.keySet()) {
            System.out.println(v);
            coins = coins - v;
            if (coins < 0) break;
            res.add(map.get(v));
        }
        int [] res_index = new int[res.size()];
        for (int i = 0 ; i < res.size(); i++){
            res_index[i] = res.get(i);
        }
        Arrays.sort(res_index);
        int [] lastRes = new int[res.size()];
        for (int i = 0 ; i < res.size(); i++){
            lastRes[i] = costs[res_index[i]];
        }
        return lastRes;
    }
}

