package cn.daidai.alg.leetcode;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class CountNumberOccInSortArray {
    public static int search(int[] nums, int target) {
        int leftIdx=binarySearch(nums,target,true);
        int rightIdx=binarySearch(nums,target,false);
        System.out.println(rightIdx);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }
    public static int binarySearch(int[] nums, int target,boolean isleft){
        int left=0;
        int right=nums.length-1;
        int ans=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target||isleft&&nums[mid]==target){
                ans=mid;
                right=mid-1;
            }else{
                left=mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(CountNumberOccInSortArray.search(nums,target));
    }
}
