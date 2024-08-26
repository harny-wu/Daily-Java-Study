package bishi.meituan.two;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.next();
            int small = 0;
            int big = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (isLower(c)) {
                    small++;
                } else {
                    big++;
                }
            }
            if (isLower(str.charAt(0))&& small == str.length()){
                System.out.println(1);
            }
            if(small >= big) {
                // 第一位为小写,需要将所有big 变成small
                if (isLower(str.charAt(0))) System.out.println(big);
                // 第一位为大写，需要将其它big 变成small
                else System.out.println(big-1);
            }else {
                // 第一位为小写,需要将所有small 变成big
                if (isLower(str.charAt(0))) System.out.println(small);
                // 第一位为大写，需要将其它small变成big
                else System.out.println(small-1);
            }
        }
    }
    public static boolean isLower(char c){
        return c >= 'a' && c <= 'z';
    }
}