package easy;

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 101. Symmetric Tree
 */
public class lc101 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int i) {
            val = i;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null  || root.right == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        } else {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
