package medium;

import basic.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * 222. Count Complete Tree Nodes
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lc222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = calcHeight(root.left);
        int r = calcHeight(root.right);
        if (l == r) {
            //左右子树高度相等，是完全左子树
            return (1 << l) + countNodes(root.right);
        } else {
            return (1 << r) + countNodes(root.left);
        }
    }
    
    private int calcHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + calcHeight(node.left);
    }
}