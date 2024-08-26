package bishi.tengxun;

import java.util.*;

/**
 * @author daiYang_wu
 */
public class Exam1 {
    public static class Node {
        int num;
        Map<Integer, String> edge;

        public Node(int num) {
            this.num = num;
            edge = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Node> nodes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i + 1));
        }
        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            String flag = sc.next();
            nodes.get(num1 - 1).edge.put(num2, flag);
            nodes.get(num2 - 1).edge.put(num1, flag);
        }
        int res = 0;
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (node.edge.size() == 0) res++;
            else {
                boolean flag = true;
                for (String v : node.edge.values()) {
                    if (!v.equals("R")) flag = false;
                }
                if (flag) res++;
            }
        }
        System.out.println(res);
    }
}
