package leetcode.byteTop;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author daiYang_wu
 * 买卖股票最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 */
public class maxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            int[] nums = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            int res = maxProfit(nums);
            System.out.println(res);
        }
    }

    // 7,1,5,3,6,4
    public static int maxProfit(int[] nums) {
        int max = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min ) {
                max = Math.max(max, nums[i] - min);
            }else{
                min = nums[i];
            }
        }
        return max;
    }
}
