package shuffle;

import java.util.*;

public class ShuffleArray {

    static Random random = new Random();


    /**
     * 时间O(n^2)  空间 O(n)
     * 1. 初始化原始数组和新数组，原始数组长度为n(已知)；
     * <p>
     * 2. 从还没处理的数组（假如还剩k个）中，随机产生一个[0, k)之间的数字p（假设数组从0开始）；
     * <p>
     * 3. 从剩下的k个数中把第p个数取出；
     * <p>
     * 4. 重复步骤2和3直到数字全部取完；
     * <p>
     * 5. 从步骤3取出的数字序列便是一个打乱了的数列。
     * <p>
     * 原文链接：https://blog.csdn.net/qq_26399665/article/details/79831490
     *
     * @param arr
     */
    public static void fisherYatesShuffle(int[] arr) {
    }

    public static void insideOutShuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, random.nextInt(arr.length));
        }
    }

    /**
     * <a href="https://blog.csdn.net/anshuai_aw1/article/details/88750673">蓄水池抽样</a>
     * 蓄水池采样，主要用于解决大数据流中的随机抽样问题，即：当内存有限，数据长度很大，甚至未知，那么如何从中随机选取k个数据，并且要求是等概率
     *
     * @param pool
     * @param k
     */
    public static int[] reservoirSampling(int[] pool, int k) {
        int[] res = new int[k];
        // 前 K 个元素直接放入数组中
        System.arraycopy(pool, 0, res, 0, k);
        for (int i = k; i < pool.length; i++) { // K + 1 个元素开始进行概率采样
            int r = random.nextInt(i + 1);
            // 这里其实就是k/j的体现
            if (r < k) {
                res[r] = pool[i];
            }
        }
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 8, 9, 10};
        System.out.println(Arrays.toString(reservoirSampling(arr,4)));
    }
}
