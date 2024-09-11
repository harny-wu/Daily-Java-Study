package meituan4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        Set<Integer> set = new HashSet<>();
        int curr = k / n;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            for (int add = 0; add < curr; add++) {
                set.add(nums[i] + add);
            }
            nums[i] = nums[i] + curr - 1;
        }
        //  可能值 k / n -->
        while (set.size() < k) {
            for (int i = 0; i < n; i++) {
                set.add(++nums[i]);
                nums[i] = nums[i] + 1;
            }
            curr++;
        }
        System.out.println(curr);
    }
}
