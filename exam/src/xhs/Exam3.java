package xhs;

import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) nums[i] = sc.nextInt();
        int minDistance = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int num : nums) {
                int dis = Math.min(Math.abs(num - i), n - Math.abs(num - i));
                total += dis;
            }
            if (total < minDistance) {
                minDistance = total;
                res = i;
            }
        }
        System.out.println(res);
    }
}
