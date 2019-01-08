//https://leetcode.com/problems/binary-tree-inorder-traversal//
//94. Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> set = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(node)) {
                ret.add(node.val);
            } else {
                set.add(node);
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return ret;
    }
}

//recursive
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorder(root, ret);
        return ret;
    }
    
    private void inorder(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        inorder(node.left, ret);
        ret.add(node.val);
        inorder(node.right, ret);
    }
}