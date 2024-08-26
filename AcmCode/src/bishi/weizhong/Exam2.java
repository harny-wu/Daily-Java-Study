package bishi.weizhong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author daiYang_wu
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        Arrays.sort(price);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int res = 0;
            for (int j = 0; j < price.length; j++ ){
                if (price[j] <= x) res++;
            }
//            int res = find(price,x) + 1;
//            if (x >= price[0] && res == 0) res = 1;
            System.out.println(res);
        }
    }

    public static int find(int [] price, int x){
        int l = 0, r = price.length -1;
        int res = 0;
        while(l <= r){
            int mid = (l + r)/ 2;
            if (price[mid] >= x){
                res = mid;
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return res;

    }
}
