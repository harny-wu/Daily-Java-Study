package ds.tree;

public class BinarySearchTree {
    TreeNode root;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int val) {
        if (root == null) this.root = new TreeNode(val);
        else insertRec(this.root, val);
    }

    public TreeNode insertRec(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }
        if (val < node.val) {
            node.left = insertRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertRec(node.right, val);
        }
        return node;
    }

    public void inOrderPrint() {
        inorderTraversalRec(this.root);
    }

    private void inorderTraversalRec(TreeNode node) {
        if (node != null) {
            inorderTraversalRec(node.left);
            System.out.print(node.val + " ");
            inorderTraversalRec(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal of the BST:");
        bst.inOrderPrint();
    }

}
