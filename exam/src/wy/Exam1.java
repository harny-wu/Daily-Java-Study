package wy;

import java.util.*;

public class Exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l1 = 0;
                int l2 = 0;
                while (l1 < o1.length() && l2 < o2.length()) {
                    char c1 = o1.charAt(l1++);
                    char c2 = o2.charAt(l2++);
                    if (c1 - 'a' < c2 - 'a') return -1;
                    if (c1 - 'a' > c2 - 'a') return 1;
                }
                if (o1.length() > o2.length()) return 1;
                if (o1.length() < o2.length()) return -1;
                return 0;
            }
        });

        set.addAll(Arrays.asList(strs));
        for (String v : set) {
            System.out.print(v + " ");
        }
    }
}
