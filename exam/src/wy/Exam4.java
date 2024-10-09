package wy;

import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int m = in.nextInt();
        int n = in.nextInt();
        int y = 0;
        String[][] grids = new String[m][n];
        for (int i = 0; i < m; i++) {
            String line = in.nextLine();
            String[] row = line.split(" ");
            for (int j = 0; j < n; j++) {
                grids[i][j] = row[j];
                if (row[j].equals("Y")) y++;
            }
        }
        System.out.println(y);
    }
}