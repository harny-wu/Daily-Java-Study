package TME;

import java.util.ArrayList;
import java.util.Arrays;;

public class Exam1 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("0001"));

    }

    public ArrayList<Integer> newArray(ArrayList<Integer> a) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>(a.size());
        for (int i = 0; i < a.size(); i++) {
            Integer num = a.get(i);
            char[] numStrChar = num.toString().toCharArray();
            for (int j = 0; j < numStrChar.length; j++) {
                if (numStrChar[j] == '2') {
                    numStrChar[j] = 'c';
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : numStrChar) {
                if (c != 'c') sb.append(c);
            }

            if (sb.length() > 0) res.add(Integer.parseInt(sb.toString()));
        }
        return res;
    }
}
