package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleSortedArrayIntersection {

    // 求两个有序数组的交集
    public static List<Integer> intersect(List<Integer> list1, List<Integer> list2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int num1 = list1.get(i), num2 = list2.get(j);
            if (num1 < num2) {
                i++;
            } else if (num1 > num2) {
                j++;
            } else {
                intersection.add(num1);
                i++;
                j++;
            }
        }
        return intersection;
    }

    // 将n个有序数组的交集逐个求出
    public static List<Integer> intersectMultipleArrays(List<List<Integer>> arrays) {
        if (arrays == null || arrays.isEmpty()) return new ArrayList<>();
        List<Integer> currentIntersection = arrays.get(0);
        for (int i = 1; i < arrays.size(); i++) {
            currentIntersection = intersect(currentIntersection, arrays.get(i));
            if (currentIntersection.isEmpty()) break;  // 如果交集为空，则后续没有必要继续计算
        }
        return currentIntersection;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = Arrays.asList(
                Arrays.asList(1, 2, 3, 5),
                Arrays.asList(1, 2, 3, 7),
                Arrays.asList(1, 3, 4, 5)
        );
        List<Integer> result = intersectMultipleArrays(arrays);
        result.forEach(num -> System.out.print(num + " "));
    }
}