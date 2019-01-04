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
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = calcHeight(root.left);
        int r = calcHeight(root.right);
        if (l == r) {
            //左右子树高度相等，是完全左子树
            return 1 + getSum(l) + countNodes(root.right);
        } else {
            return 1 + getSum(r) + countNodes(root.left);
        }
    }
    
    private int getSum(int level) {
        int sum  = 0;
        int temp  = 1;
        for (int i = 0; i < level; i++) {
            sum += temp;
            temp = temp * 2;
        }
        return sum;
    }

    
    private int calcHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + calcHeight(node.left);
    }
}