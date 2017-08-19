package main.easy;

/**
 * Author:maslke
 * Date:2017/8/19
 * Version:0.0.1
 * 404. Sum of Left Leaves
 */
public class lc404 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return getLeftSum(root.left) + getRightSum(root.right);
    }

    private int getLeftSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.val;
        }
        return getLeftSum(node.left) + getRightSum(node.right);
    }

    private int getRightSum(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return getLeftSum(node.left) + getRightSum(node.right);
    }
}
