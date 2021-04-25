package easy;

import basic.TreeNode;

// https://leetcode-cn.com/problems/increasing-order-search-tree/
// 897. 递增顺序搜索树
public class lc897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            TreeNode left = increasingBST(root.left);
            TreeNode prev = prev(left);
            prev.right = root;
            root.left = null;
            root.right = increasingBST(root.right);
            return left;
        } else if (root.right != null) {
            root.right = increasingBST(root.right);
            return root;
        }

        return root;
    }

    private TreeNode prev(TreeNode root) {
        TreeNode prev = root;
        while (prev.right != null) {
            prev = prev.right;
        }
        return prev;
    }
}
