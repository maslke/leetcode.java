package easy;

import basic.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

//https://leetcode.com/problems/leaf-similar-trees/
//872. Leaf-Similar Trees
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class lc872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> values1 = leafs(root1);
        List<Integer> values2 = leafs(root2);
        return values1.equals(values2);
    }

    private List<Integer> leafs(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                values.add(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return values;
    }
}