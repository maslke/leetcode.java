package medium;

import basic.TreeNode;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class lc1309 {


    // 层次遍历的方式
    // faster
    public int deepestLeavesSum2(TreeNode root) {
        if (root == null) return 0;
        int value  = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean lastLevel = true;
            int v = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    lastLevel = false;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    lastLevel = false;
                }
                v += node.val;
                if (lastLevel) {
                    value = v;
                }
            }
        }
        
        return value;
    }


    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        int maxLength = 0;
        int value  = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int length = map.get(node);
            if (node.left == null && node.right == null) {
                if (length > maxLength) {
                    value = node.val;
                    maxLength = length;
                } else if (length == maxLength) {
                    value += node.val;
                }
            }
            if (node.right != null) {
                stack.push(node.right);
                map.put(node.right, length + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                map.put(node.left, length + 1);
            }
        }
        
        return value;
    }
}