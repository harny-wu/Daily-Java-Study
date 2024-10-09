package wy;

import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int l = 0, r = s.length() - 1;
        int add = 0;
        while (l < r) {
            char sl = s.charAt(l);
            char sr = s.charAt(r);
            int lInt = Integer.parseInt(String.valueOf(sl));
            int rInt = Integer.parseInt(String.valueOf(sr)) + add;
            add = 0;
            if (lInt == rInt) sb.append(0);
            if (rInt < lInt) sb.append(lInt - rInt);
            else {
                sb.append(lInt + 10 - rInt);
                add = 1;
            }
            l++;
            r--;
        }
        sb.reverse();
        int start = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') start++;
        }
        System.out.println(sb.substring(start,sb.length()));
    }
}
