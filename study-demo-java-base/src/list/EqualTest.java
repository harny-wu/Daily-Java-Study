package list;

import java.util.*;

/**
 * @author daiYang_wu
 */
public class EqualTest {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3);
        List<Integer> l1 = new ArrayList<>(l);
        List<Integer> l2 = new LinkedList<>(l);

        System.out.println(l1);
        System.out.println(l2);


        System.out.println(l1 == l2);

        System.out.println(l1.equals(l2));

        Iterator iterator = l.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());

    }
}
