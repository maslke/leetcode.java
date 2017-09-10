package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/9/10
 * Version:0.0.1
 * 543. Diameter of Binary Tree
 */
public class lc543 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }

    private int diameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int v3 = maxDepth(node.left) + maxDepth(node.right);
        int v1 = diameter(node.left);
        int v2 = diameter(node.right);
        return Math.max(v3,Math.max(v1, v2));
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(node, 1);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode temp  =stack.pop();
            if (temp.left == null && temp.right == null) {
                if (max < map.get(temp)) {
                    max = map.get(temp);
                }
            }
            if (temp.right != null) {
                stack.push(temp.right);
                map.put(temp.right, map.get(temp) + 1);
            }
            if (temp.left != null) {
                stack.push(temp.left);
                map.put(temp.left, map.get(temp) + 1);
            }
        }
        return max;
    }
}
