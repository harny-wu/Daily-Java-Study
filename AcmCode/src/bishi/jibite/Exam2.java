package bishi.jibite;

import java.util.Scanner;

/**
 * 给定长度为n的序列a1,a2,...,an，考虑将连续相邻的若干个（1个或多个）元素分组并求和，
 * 得到一个新的单调不减序列，要求满足条件的最大分组数。
 * @author daiYang_wu
 */
public class Exam2 {
    public static void main(String[] args) {

        System.out.println();


        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n ; i++){
            arr[i] = in.nextInt();
        }
        int [] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i <n ;i++) prefix[i] = prefix[i-1] + arr[i];
        System.out.print(1);
    }
}
