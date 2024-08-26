package bishi.mihoyo;

import java.util.*;

/**
 * @author daiYang_wu
 */
public class Exam1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = 0;
        int m = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            n = in.nextInt();
            m = in.nextInt();
        }
        String s = in.next();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (!map.containsKey(x)) {
                if (i == n - 1) {
                    map.put(x, s.substring(i, i + 1) + "S");
                } else {
                    map.put(x, s.substring(i, i + 1));
                }
            } else {
                if (i == n - 1) {
                    map.put(x, map.get(x) + s.substring(i, i + 1) + "S");
                } else {
                    map.put(x, map.get(x) + s.substring(i, i + 1));
                }
            }
        }
        for (String str : map.values()){
            System.out.println(sort(str));
        }
    }
    public static String sort(String str){
        StringBuilder sb = new StringBuilder();
        int [] temp = new int[10];
        for (int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            if (c == 'S') temp[0] = temp[0] + 1;
            else{
                temp[c - 'A' + 1] = temp[c - 'A' + 1] +1;
            }
        }
        for (int i = 0; i < temp[0];i++) sb.append('S');
        for (int i = 0; i < 9; i++){
            char n = (char) ('A' + i);
            for (int k = 0;  k <temp[i+1]; k++){
                sb.append(n);
            }
        }
        return sb.toString();
    }

}