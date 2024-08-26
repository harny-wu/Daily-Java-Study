package bishi.meituan.three;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author daiYang_wu
 */
public class Main {
    public static void main(String[] args) {
        int l = 10;
        for (int i = 1; i < 9; i++) l *= 10;
        System.out.println(l + 7);
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int q = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = in.nextInt();
            System.out.println(Arrays.toString(nums));
            for (int i = 0; i < q; i++) {
                int k = in.nextInt();
                for (int j = 0; j < n; j++) {
                    if (j != k-1) nums[j] = nums[j] << 1;
                }
                System.out.println(Arrays.toString(nums));
            }
            long res = 0;
            for (int i = 0; i < n; i++) {
                res += nums[i];
            }
            System.out.println(res%1000000007);
        }
    }
}
