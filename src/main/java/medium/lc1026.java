package medium;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/submissions/
// 1026. Maximum Difference Between Node And Ancestor
class Solution {
    public int maxAncestorDiff2(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> set = new HashSet<>();
        map.put(root, null);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(node)) {
                TreeNode parent = map.get(node);
                while (parent != null) {
                    if (max < Math.abs(parent.val - node.val)) {
                        max = Math.abs(parent.val - node.val);
                    }
                    parent = map.get(parent);
                }
            } else {
                stack.push(node);
                set.add(node);
                if (node.right != null) {
                    stack.push(node.right);
                    map.put(node.right, node);
                }
                if (node.left != null) {
                    stack.push(node.left);
                    map.put(node.left, node);
                }
            }
        }
        return max;
    }


    public int maxAncestorDiff(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, null);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    map.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode parent = map.get(node);
                while (parent != null) {
                    if (max < Math.abs(parent.val - node.val)) {
                        max = Math.abs(parent.val - node.val);
                    }
                    parent = map.get(parent);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return max;
    }
}