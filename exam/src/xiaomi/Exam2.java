package xiaomi;

import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        int target = (sum / x) * x;
        int diff = sum - target;

        int minOperations = diff;
        // 删除
        for (int num : nums) {
            int currSum = sum - num;
            int currTarget = (currSum / x) * x;
            int currDiff = currSum - currTarget;
            minOperations = Math.min(minOperations, currDiff + 1);
        }
        // 加1
        for (int num : nums) {
            int currSum = sum + 1;
            int currTarget = (currSum / x) * x;
            int currDiff = currSum - currTarget;
            minOperations = Math.min(minOperations, currDiff);
        }
        System.out.println(minOperations);
    }
}
