package sxf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                if (i - k < 0) {
                    dp[i] = Math.max(nums[i], dp[i - 1]);
                } else {
                    dp[i] = Math.max(nums[i] + dp[i - k], dp[i - 1]);
                }
            }
            System.out.println(dp[n - 1]);
        }
    }
}
