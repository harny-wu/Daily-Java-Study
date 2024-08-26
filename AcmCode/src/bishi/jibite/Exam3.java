package bishi.jibite;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author daiYang_wu
 */
public class Exam3 {
    static int  min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int m = in.nextInt();
        int n = in.nextInt();
        int [][] arr = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = in.nextInt();
            }
        }
        LinkedList<Integer> trace = new LinkedList<>();
        dfs(arr,0,0,m,n,trace);

        System.out.print(min);
    }
    public static void dfs(int [][] arr, int i, int j,int m, int n, LinkedList<Integer> trace){
        if(i > m -1 || j > n -1 || i < 0 || j < 0 ) return;
        trace.addLast(arr[i][j]);
        if (i == m - 1 && j == n - 1){
            int curr_min = getMin(trace);
            if (curr_min <= 0){
                min = Math.min((-curr_min) +1,min);
            }
        }
        dfs(arr, i+1, j, m, n,trace);
        dfs(arr, i, j+1, m, n,trace);
        trace.removeLast();
        return;
    }

    public static int getMin(LinkedList<Integer> trace){
        int min = trace.getFirst();
        for (int i = 1; i < trace.size(); i++){
            int curr = trace.get(i);
            min = Math.min(min,min + curr);
        }
        return min;
    }
}
