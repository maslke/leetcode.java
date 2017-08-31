package easy;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 * 110. Balanced Binary Tree
 */
public class lc110 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int h1 = 1 + getHeight(root.left);
        int h2 = 1 + getHeight(root.right);
        if (Math.abs(h1 - h2) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
