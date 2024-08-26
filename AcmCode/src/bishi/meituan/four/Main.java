package bishi.meituan.four;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author daiYang_wu
 * 小美拿到了一个数组。她希望你求出所有区间众数之和。你能帮帮她吗？
 * 定义区间的众数为出现次数最多的那个数。如果有多个数出现次数最多，那么众数是其中最小的那个数
 * <p>
 * 第一行输入一个正整数n，代表数组的大小。
 * 第二行输入n个正整数a_i，代表数组的元素。
 * 1\leq n \leq 200000
 * 1\leq a_i \leq 2
 */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextInt()) { // 注意 while 处理多个 case
                int n = in.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = in.nextInt();
                }
                int res = 0;
    //            HashMap<Integer, Integer> count = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        int max = findMax2(i,j,nums);
                        System.out.println(i + "  " + j + "  " + max );
                        res += max;
                    }
                }
                System.out.println(res);
            }
        }
        public static int findMax2(int l, int r, int[]nums){
            if (l == r) return nums[l];
            Map<Integer,Integer> map = new HashMap<>();

            int maxKey = nums[l];
            int maxCount = -1;
            for (int i = l ; i <= r; i++){
                int count = map.getOrDefault(nums[i],0) + 1;
                map.put(nums[i],count);
                if (count > maxCount || (count == maxCount && nums[i] < maxKey)){
                    maxKey = nums[i];
                    maxCount = count;
                }

            }
            return maxKey;
        }

    public static int findMax(Map<Integer,Integer> map) {
        int maxKey = 0;
        int maxCount = -1;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() > maxCount || (entry.getValue() == maxCount&&entry.getKey() < maxKey)){
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
