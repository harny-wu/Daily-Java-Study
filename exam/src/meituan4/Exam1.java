package meituan4;

import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res = 0;
        String[] ss = s.split(" ");
        for (String curr : ss) {
            if (!curr.isEmpty()) {
                char c = curr.charAt(0);
                if (c - 'A' >= 0 && c - 'A' <= 25) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
