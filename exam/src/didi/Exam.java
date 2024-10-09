package didi;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        int max = 0;
        int curr = nums[0];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
        int l = -1, r = 0;
        while (r < n) {
            while (curr > m) {
                curr -= nums[l++];
            }
            while (curr < m) {
                max = Math.max(r - l, max);
                curr += nums[r++];
            }
        }
        System.out.println(max);
    }
}
