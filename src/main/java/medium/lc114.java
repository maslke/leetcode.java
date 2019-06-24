package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/23
 * Version:0.0.1
 * 114. Flatten Binary Tree to Linked List
 */
public class lc114 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> ret = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ret.add(temp);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        for (int i = 0; i < ret.size() - 1; i++) {
            ret.get(i).left = null;
            ret.get(i).right = ret.get(i + 1);
        }
        ret.get(ret.size() - 1).left = null;
        ret.get(ret.size() - 1).right = null;
    }

    // a better solution
    public void flatten2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
            if (!stack.isEmpty()) {
                node.right = stack.peek();
            }
        }
    }
}
