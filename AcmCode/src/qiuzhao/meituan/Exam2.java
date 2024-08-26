package qiuzhao.meituan;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author daiYang_wu
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long k = in.nextLong();
        long[] arr = new long[]{a, b, c};
        Arrays.sort(arr);
        // 最小数
        if (arr[1] - arr[0] <= k) {
            k -= (arr[1] - arr[0]);
            arr[0] = arr[1];
        } else {
            arr[0] += k;
            k = 0;
        }
        // 第二小数2
        if (k > 0) {
            if (2 * (arr[2] - arr[1]) <= k) {
                k -= (2 * (arr[2] - arr[1]));
                arr[0] = arr[1] = arr[2];
            } else {
                arr[0] += k / 2;
                k -= (k / 2);
                arr[1] += k;
                k = 0;
            }
        }
        if (k > 0){
            arr[0] += k / 3;
            k -= (k / 3);
            arr[1] += k / 3;
            k -= (k / 3);
            arr[0] += k ;
        }

        long res = arr[0];
        res = res * arr[1];
        res = res * arr[2];
        System.out.print(res);
    }

}
