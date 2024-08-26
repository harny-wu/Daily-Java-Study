package leetcode.byteTop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author daiYang_wu
 * <p>
 * 最长无重复字串
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int left = -1, res = 0;
            Map<Character, Integer> dict = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (dict.containsKey(c))
                    left = Math.max(left, dict.get(c));
                dict.put(c, i);
                res = Math.max(res, i - left);
            }
            System.out.println(res);
        }
    }

}
