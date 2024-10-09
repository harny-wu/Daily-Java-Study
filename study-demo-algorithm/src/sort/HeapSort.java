package sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        heapSort(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] nums) {
        // 堆化
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            shiftDown(nums, i, nums.length);
        }
        // 排序
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            shiftDown(nums, 0, i);
        }
    }


    /**
     * @param nums
     * @param i    开始shift down 的地方
     * @param n    堆堆长度
     */
    public static void shiftDown(int[] nums, int i, int n) {
        int l = 2 * i + 1, r = 2 * i + 2;
        int g = i;
        if (l < n && nums[l] > nums[g]) g = l;
        if (r < n && nums[r] > nums[g]) g = r;

        if (g == i) return;
        swap(nums, i, g);
        shiftDown(nums, g, n);
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}