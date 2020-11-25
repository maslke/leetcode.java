package medium;

import basic.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

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
class lc94 {
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

    //solution 2
    public List<Integer> inorderTraversal2(TreeNode root) {
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
