package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/delete-leaves-with-a-given-value/
// 1325. Delete Leaves With a Given Value

class lc1325 {


    public TreeNode removeLeafNodes2(TreeNode root, int target) {
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Map<TreeNode, TreeNode> leftMap = new HashMap<>();
        Map<TreeNode, TreeNode> rightMap = new HashMap<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (!set.contains(node)) {
                set.add(node);
                stack.push(node);
                if (node.right != null) {
                    stack.push(node.right);
                    rightMap.put(node.right, node);
                }
                if (node.left != null) {
                    stack.push(node.left);
                    leftMap.put(node.left, node);
                }
            } else {
                if (node.val == target && node.left == null && node.right == null) {
                    if (leftMap.get(node) != null) {
                        leftMap.get(node).left = null;
                    } else if (rightMap.get(node) != null) {
                        rightMap.get(node).right = null;
                    } else {
                        return null;
                    }
                    
                }
            }
        }
        return root;
        
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target && childrenAllTarget(root, target)) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return root;
    }

    private boolean childrenAllTarget(TreeNode node, int target) {
        if (node == null) return true;
        return node.val == target && childrenAllTarget(node.left, target) && childrenAllTarget(node.right, target);
    }
}