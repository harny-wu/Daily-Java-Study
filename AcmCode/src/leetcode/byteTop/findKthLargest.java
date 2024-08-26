package leetcode.byteTop;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 * 寻找第K大的数
 *
 * @author daiYang_wu
 */
public class findKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelectV2(nums, 0, nums.length - 1, k);
    }

    public static int findKthLargestByHead(int [] nums ,int k){
        PriorityQueue<Integer> head = new PriorityQueue<>();
        return 1;
    }

    public static int quickSelectV2(int[] nums, int l, int r, int k) {
        int pivot = nums[l];
        int i = l, j = r;
        while (i < j) {
            while (nums[j] < pivot) {
                j--;
            }
            if (i < r) nums[i++] = nums[j];
            while (nums[i] > pivot) {
                i++;
            }
            if (i < r) nums[j--] = nums[i];
        }
        nums[i] = pivot;
        if (i == k) return pivot;
        else if (i < k) return quickSelectV2(nums, i + 1, r, k);
        else return quickSelectV2(nums, l, i - 1, k);
    }

}
