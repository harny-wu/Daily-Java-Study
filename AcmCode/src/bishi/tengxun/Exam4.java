package bishi.tengxun;

import java.util.Scanner;

/**
 * @author daiYang_wu
 */
public class Exam4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 1; i < n ; i++){
            int res = calculate(nums,i);
            max = Math.max(max,res);
        }
        System.out.println(max);
    }
    public static int calculate(int [] nums, int s){
        int l = nums[0];
        int r = nums[nums.length-1];
        for (int i = 1; i < s; i++){
            l = l | nums[i];
        }
        for (int i = s; i < nums.length; i++){
            r = r | nums[i];
        }
        return l + r;
    }
}
