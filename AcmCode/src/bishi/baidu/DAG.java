package bishi.baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 百度 2月29
 * @author daiYang_wu
 */
public class DAG {

    public static void main(String[] args) {
        List<Node> nodes = initDAG();

        // 开始节点集合
        List<Node> currNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node.parent.size() == 0) {
                currNodes.add(node);
            }
        }

        // 子节点集合
        Map<String,Node> nextNodes;
        while (currNodes.size() != 0 ) {
            nextNodes = new HashMap<>(); // 重新初始化
            for (Node currNode : currNodes) {
                System.out.println(currNode.no);
                if (currNode.child != null && !nextNodes.containsKey(currNode.no)){
                        nextNodes.put(currNode.no,currNode);
                }
            }

            currNodes = new ArrayList<>();
            currNodes.addAll(nextNodes.values());
        }
    }

    public static List<Node> initDAG() {
        List<Node> dag = new ArrayList<>();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        a.child = c;
        b.child = c;
        c.child = d;
        c.parent.add(a);
        c.parent.add(b);
        d.parent.add(c);
        dag.add(a);
        dag.add(b);
        dag.add(c);
        dag.add(d);
        return dag;
    }

    public static class Node {
        List<Node> parent = new ArrayList<>();
        Node child;
        String no;

        public Node(String no) {
            this.no = no;
        }
    }

}
