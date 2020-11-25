package medium;

import basic.TreeNode;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
// 1372. Longest ZigZag Path in Binary Tree
class lc1372 {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        visit(root, true);
        return max;
    }
    
    private int visit(TreeNode node, boolean left) {
        if (node == null) return 0;
        int l = visit(node.left, true);
        int r = visit(node.right ,false);
        int m = l > r ? l : r;
        if (m > max) max = m;
        if (left) {
            return r + 1;
        } else {
            return l + 1;
        }
    }
}