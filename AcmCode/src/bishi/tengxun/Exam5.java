package bishi.tengxun;

import java.util.Scanner;

/**
 * @author daiYang_wu
 */
public class Exam5 {
    static int res = 0;
    static String goal = "tencent";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, "", map);
            }
        }
        System.out.println(res);
    }

    public static void dfs(int x, int y, String curr, char[][] map) {

        if (x < 0 || y < 0 || x > map.length-1 || y > map[0].length-1 || map[x][y] == '!') return;
        char c = map[x][y];
        curr = curr + c;
        if (curr.equals(goal)) {
            res++;
            return;
        }
        if (!curr.equals(goal.substring(0, curr.length()))) return;

//        map[x][y] = '!';
        dfs(x + 1, y, curr, map);
        dfs(x - 1, y, curr, map);
        dfs(x, y + 1, curr, map);
        dfs(x, y - 1, curr, map);
//        map[x][y] = c;
    }
}
