package easy;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 538. Convert BST to Greater Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convert(root);
        return root;
    }
    
    private void convert(TreeNode node) {
        if (node == null) return;
        convert(node.right);
        
        sum += node.val;
        node.val = sum;
        
        convert(node.left);
        }    
   
}