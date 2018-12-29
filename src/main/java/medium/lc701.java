/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return root;
            } else {
                insertIntoBST(root.left, val);
                return root;
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            } else {
                insertIntoBST(root.right, val);    
                return root;
            }
        }
    }
}