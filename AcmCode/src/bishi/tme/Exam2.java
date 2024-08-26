package bishi.tme;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author daiYang_wu
 */
public class Exam2 {

    public static void main(String[] args) {
        TreeNode root = create(3);
        System.out.println(root.val);
    }

    public static TreeNode create(int n) {
        // write code here
        TreeNode root = new TreeNode(2 << (n - 2));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 2; i <= n; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = q.poll();
                int num;
                if (i == n) num = 1;
                else num = 2 << (n - i - 1);
                node.left = new TreeNode(num);
                node.right = new TreeNode(num);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
