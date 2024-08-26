package leetcode.byteTop;

/**
 * @author daiYang_wu
 */
public class BinaryTree {

    public static class BinaryNode {
        public BinaryNode left;
        public BinaryNode right;
        public int val;

        public BinaryNode(int val) {
            this.val = val;
        }

    }

    public static BinaryNode init() {
        BinaryNode root = new BinaryNode(3);
        root.left = new BinaryNode(9);
        root.right = new BinaryNode(20);
        root.right.left = new BinaryNode(15);
        root.right.right = new BinaryNode(7);
        return root;
    }
}
