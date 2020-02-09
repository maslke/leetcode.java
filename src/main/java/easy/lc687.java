package easy;

//https://leetcode.com/problems/longest-univalue-path/
//687. Longest Univalue Path
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lc687 {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.val, root.left);
        int rh = height(root.val, root.right);
        int v1 = longestUnivaluePath(root.left);
        int v2 = longestUnivaluePath(root.right);
        return Math.max(lh + rh, Math.max(v1, v2));
    }
    
    private int height(int val, TreeNode node) {
        if (node == null) return 0;
        if (node.val != val) return 0;
        return 1 + Math.max(height(val, node.left), height(val, node.right));
    }
}