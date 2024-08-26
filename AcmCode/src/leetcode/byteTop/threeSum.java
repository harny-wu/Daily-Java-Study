package leetcode.byteTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author daiYang_wu
 */
public class threeSum {
    public static void main(String[] args) {
        int [] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        for (int i =0;i<nums.length-1;i++){
            int curr = nums[i];
            int l = i+1, r = nums.length-1;
            if (curr > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            while(l < r){
                int sum = curr + nums[l] + nums[r];
                if (sum == 0){
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while( l < r && nums[l] == nums[++l]); // 需要先进行++操作，如果nums[l] == num[l++]不成立，会无限循环
                    while( l < r && nums[r] == nums[--r]);
                }
                else if (sum < 0) {
                    while( l < r && nums[l] == nums[++l]);
                }
                else if (sum > 0){
                    while( l < r && nums[r] == nums[--r]);
                }
            }
        }
        System.out.println(res.toString());
    }
}
