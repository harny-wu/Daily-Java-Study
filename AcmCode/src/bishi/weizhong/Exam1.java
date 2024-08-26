package bishi.weizhong;


import java.util.Scanner;

/**
 * @author daiYang_wu
 */
public class Exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] res = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int x = sc.nextInt();
            if (x == 1 || x == 2 || x == 3) {
                swap(x - 1, 0, x - 1, 2, res);
                swap(x - 1, 1, x - 1, 2, res);
            } else if (x == 4 || x == 5 || x == 6) {
                swap(0, x - 4, 2, x - 4, res);
                swap(0, x - 4, 1, x - 4, res);
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(res[i][0] + " " + res[i][1] + " " + res[i][2]);
        }
    }

    public static void swap(int x1, int y1, int x2, int y2, int[][] nums) {
        int temp = nums[x1][y1];
        nums[x1][y1] = nums[x2][y2];
        nums[x2][y2] = temp;
    }
}
