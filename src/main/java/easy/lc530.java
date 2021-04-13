package easy;

import basic.TreeNode;

// https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
// 530. 二叉搜索树的最小绝对差

public class lc530 {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        preorder(root);
        return min;
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        preorder(node.left);
        if (prev == null) {
            prev = node;
        }
        else {
            min = Math.min(min, node.val - prev.val);
            prev = node;
        }
        preorder(node.right);
    }
}
