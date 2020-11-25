package medium;

import basic.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lc1038 {

    int sum = 0;
    public TreeNode bstToGst2(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst2(root.right);
        root.val += sum;
        sum = root.val;
        bstToGst2(root.left);
        return root;
    }

    public TreeNode bstToGst3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (!set.contains(node)) {
                if (node.left != null) {
                    stack.push(node.left);
                }

                stack.push(node);
                if (node.right != null) {
                    stack.push(node.right);
                }
                set.add(node);
            } else {
                node.val += sum;
                sum = node.val;
            }
        }


        return root;
    }

    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();     
        traverse(root, list);
        int totalValue = 0;
        for (int i = 0; i < list.size(); i++) {
            totalValue += list.get(i).val;
        }
        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i).val;
            list.get(i).val = totalValue;
            totalValue -= m;
        }
        return root;
    }
    
    private void traverse(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        traverse(node.left, list);
        list.add(node);
        traverse(node.right, list);
    }
}