package hot100.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int v) {
        val = v;
    }

    public TreeNode initTreeByPrev(int [] nums){
        TreeNode root = new TreeNode(nums[0]);
        return root;
    }
}
