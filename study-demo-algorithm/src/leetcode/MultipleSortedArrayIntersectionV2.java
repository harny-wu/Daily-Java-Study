package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleSortedArrayIntersectionV2 {


    public static List<Integer> intersect(List<Integer> list1, List<Integer> list2){
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()){
            int v1 = list1.get(i), v2 = list2.get(j);
            if (v1 > v2) j++;
            else if (v2 > v1) i++;
            else {
                intersection.add(v1);
                i++;
                j++;
            }
        }
        return intersection;
    }

    public static List<Integer> multiIntersect(List<List<Integer>>lists){
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = lists.get(0);
        for (int i = 1; i < lists.size(); i++){
            res = intersect(list1,lists.get(i));
            if (res.isEmpty()) return res;
        }
        return res;
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1,2,3,4),
                Arrays.asList(2,3,4,5),
                Arrays.asList(2,4,5,6)
        );

        System.out.println(multiIntersect(lists));

    }
}
