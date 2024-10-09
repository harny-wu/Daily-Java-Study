package exam58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Exam1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param firstList  int整型二维数组
     * @param secondList int整型二维数组
     * @return int整型二维数组
     */
    public void findIntersection(int[][] firstList, int[][] secondList) {
        // write code here
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(firstList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        res.add(new int[]{1, 2});
    }

    public static void main(String[] args) {

    }
}
