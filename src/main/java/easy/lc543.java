package easy;

//https://leetcode.com/problems/diameter-of-binary-tree/
//543. Diameter of Binary Tree

import basic.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lc543 {

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
       
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        return Math.max(lh + rh, Math.max(ld, rd));
    }
    
    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        length(root);
        return max;
    }

    private int length(TreeNode node) {
        if (node == null) return 0;
        int l = length(node.left);
        int r = length(node.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
