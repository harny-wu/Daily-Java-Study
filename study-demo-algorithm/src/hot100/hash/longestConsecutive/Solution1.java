package hot100.hash.longestConsecutive;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence">最长连续序列.</a>
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] nums = Arrays.stream(line.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int v : set) {
            if (!set.contains(v + 1)) {
                int n = 1;
                while (set.contains(--v)) {
                    n++;
                }
                max = Math.max(n, max);
            }
        }
        System.out.println(max);
    }
}
