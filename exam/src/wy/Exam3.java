package wy;

import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String line = sc.nextLine();
            if (line.charAt(0) != '[') System.out.println("invalid 0");
            for (int i = 1; i < line.length(); i++){
                char curr = line.charAt(i);
                char pre = line.charAt(i-1);
                if (pre == ',' && curr == ',') System.out.println("invalid " + pre);
                if (pre == '[' && curr == ',') System.out.println("invalid " + pre);
                if (pre != ',' && curr == '[') System.out.println("invalid " + pre);
            }
        }
    }
}
