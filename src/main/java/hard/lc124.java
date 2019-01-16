//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//124. Binary Tree Maximum Path Sum
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        
        int l = path(root.left);
        
        int r = path(root.right);
        
        int v1 = root.val + l + r;
        int v2 = root.val + l;
        int v3 = root.val + r;
    
        
        int max = Math.max(v1, v2);
        max = Math.max(max, v3);
        max = Math.max(max, root.val);
        if (root.left != null) {
            max = Math.max(max, maxPathSum(root.left));
        }
        if (root.right != null) {
            max = Math.max(max, maxPathSum(root.right));
        }
        return max;
        
    }
    
    private int path(TreeNode node) {
        
        if (node == null) return 0;
        return Math.max(node.val, node.val + Math.max(path(node.left), path(node.right)));
        
    }
}