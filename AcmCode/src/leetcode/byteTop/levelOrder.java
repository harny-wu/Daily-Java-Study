package leetcode.byteTop;

import java.util.*;

/**
 * @author daiYang_wu
 */
public class levelOrder {
    public static void main(String[] args) {
        BinaryTree.BinaryNode root = BinaryTree.init();
        System.out.println(levelOrder(root).toString());
    }

    public static List<List<Integer>> levelOrder(BinaryTree.BinaryNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<BinaryTree.BinaryNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level;
        while (queue.size() > 0) {
            int n = queue.size();
            level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                BinaryTree.BinaryNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                level.add(node.val);
            }
            res.add(level);
        }
        return res;
    }
}
