package easy;

import basic.TreeNode;

// https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
// 783. 二叉搜索树节点最小距离

public class lc783 {
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        preorder(root);
        return min;
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        if (prev == null) {
            prev = root;
        }
        else {
            min = Math.min(root.val - prev.val, min);
            prev = root;
        }
        preorder(root.right);
    }

    public int minDiffInBST2(TreeNode root) {
        return minDiff(root);
    }

    private int minDiff(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left != null && node.right != null) {
            TreeNode leftRight = leftRight(node.left);
            TreeNode rightLeft = rightLeft(node.right);
            int v1 = node.val - leftRight.val;
            int v2 = rightLeft.val - node.val;
            int v3 = minDiff(node.left);
            int v4 = minDiff(node.right);
            return Math.min(Math.min(v1, v2), Math.min(v3, v4));
        }
        else if (node.left != null) {
            TreeNode leftRight = leftRight(node.left);
            int v1 = node.val - leftRight.val;
            int v2 = minDiff(node.left);
            return Math.min(v1, v2);
        }
        else if (node.right != null) {
            TreeNode rightLeft = rightLeft(node.right);
            int v1 = rightLeft.val - node.val;
            int v2 = minDiff(node.right);
            return Math.min(v1, v2);
        }
        else {
            return Integer.MAX_VALUE;
        }
    }

    private TreeNode leftRight(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode rightLeft(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
