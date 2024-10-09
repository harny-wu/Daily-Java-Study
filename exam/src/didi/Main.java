package didi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    /**
     * N nums 长度，
     *
     * @param nums
     */
    public static void findInter(List<int[]> nums) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int[] num = nums.get(i);
            for (int v : num) {
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == nums.size()) {
                res.add(entry.getKey());
            }
        }
        System.out.println(res.toString());
    }

    /**
     * O (N k log k)
     * O (1)
     *
     * @param nums
     */
    public static void find2(List<int[]> nums) {
        int[] nums1 = nums.get(0);
        List<Integer> res = new LinkedList<>();
        boolean flag = true;
        for (int v : nums1) {
            flag = true;
            for (int i = 1; i < nums.size(); i++) {
                int[] numsX = nums.get(i);
                if (!isInNums(numsX, v)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(v);
        }
        System.out.println(res.toString());
    }

    //    public static void  find3(List<int[]> nums){
//        int l = 0;
//        int r = findMinLength(nums);
//        int min = nums.get(0)[0];
//        for ()
//    }
    public static boolean isInNums(int[] nums, int g) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == g) return true;
            else if (nums[mid] < g) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {

        List<int[]> nums = new LinkedList<>();
        nums.add(new int[]{3, 4, 5, 6, 8});
        nums.add(new int[]{0, 2, 3, 4, 5, 8});
        nums.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        nums.add(new int[]{0, 1, 4, 8});
        find2(nums);
    }
}
