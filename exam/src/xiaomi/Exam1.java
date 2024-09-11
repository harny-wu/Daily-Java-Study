package xiaomi;

import java.util.Map;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] aT = new int[n];
        int[] bT = new int[n];
        int minA = 0;
        int minB = 0;
        for (int i = 0; i < n; i++) {
            aT[i] = sc.nextInt();
            if (aT[i] < aT[minA]) minA = i;
        }
        for (int i = 0; i < n; i++) {
            bT[i] = sc.nextInt();
            if (bT[i] < bT[minB]) minB = i;
        }
        if (minA != minB) {
            System.out.println(Math.max(aT[minA],bT[minB]));
        }else {
            System.out.println();
        }
    }
}
