package math;

import java.sql.SQLOutput;

/**
 * 、
 * 、快速幂相关
 */
public class Pow {

    // x ^ n
    public static long binPow(int x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = res * x;
            x *= x;
            n >>= 1;
        }
        return res;
    }

    // x ^ n % mod
    public static long binPowMod(int x, int n , int mod){
        long res = 1;
        x = x % mod;
        while (n > 0) {
            if ((n & 1) == 1) res = res * x % mod;
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }

    /**
     * 1 & 1 = 1
     * 3 = 0011 & 0001 = 1
     */
    public static void main(String[] args) {
        System.out.println(1 & 1);
        System.out.println(0 & 1);
        System.out.println(0 & 0);
        System.out.println(3 & 1);

        System.out.println(binPow(5, 5));
        System.out.println(Math.pow(5,5) % 3);
        System.out.println(binPowMod(5,5,3));
    }
}
