package sxf;

import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String n = in.nextLine();
        String s = in.nextLine();
        int res = 0;
        int nIdx = 0;
        int i = 0;
        while (i < s.length()) {
            char nc = n.charAt(nIdx);
            char sc = s.charAt(i);
            if (sc == '*') {
                char curr = s.charAt(i - 1);
                while (nIdx < n.length() && n.charAt(nIdx) == curr) {
                    nIdx++;
                    res++;
                }
            } else if (nc == sc) {
                nIdx++;
                res++;
            }
            i++;
        }
        System.out.print(res);
    }
}
