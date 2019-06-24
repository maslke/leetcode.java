package medium;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int val = root.val;
        if (val == R) {
            return rangeSumBST(root.left, L, R) + val;
        } else if (val > R) {
            return rangeSumBST(root.left, L, R);
        } else if (val == L) {
            return rangeSumBST(root.right, L, R) + val;
        } else if (val < L) {
            return rangeSumBST(root.right, L, R);
        } else {
            return rangeSumBST(root.left, L, R) + val + rangeSumBST(root.right, L, R);
        }
        
    }
}