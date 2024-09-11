package sort;

import java.util.Arrays;

public class QuickSort {

    /* 元素交换 */
    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int pivotIdx = l;
        while (l < r) {
            // 以 index = l 为基准
            while (l < r && nums[r] >= pivot)
                r--;          // 从右向左找首个小于基准数的元素
            while (l < r && nums[l] <= pivot)
                l++;          // 从左向右找首个大于基准数的元素
            swap(nums, l, r); // 交换这两个元素
        }
        swap(nums, l, pivotIdx);
        return l;
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot - 1);
        quickSort(nums, pivot + 1, r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 323, 31, 2, 4, 12};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
