package hard;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import basic.TreeNode;

// https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
// 剑指 Offer 37. 序列化二叉树

public class Offer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        StringBuilder sb  = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> set = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(node)) {
                if (node.right != null) {
                    stack.push(node.right);
                } else {
                    sb.append(",#");
                }
            } else {
                set.add(node);
                stack.push(node);
                sb.append(",").append(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                } else {
                    sb.append(",#");
                }
            }
        }
        return sb.toString().substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] parts = data.split(",");
        TreeNode root = null;
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < parts.length; i++) {
            String p = parts[i];
            TreeNode node = null;
            if (!p.equals("#")) {
                node = new TreeNode(Integer.parseInt(p));
            }
            if (stack.isEmpty()) {
                stack.push(node);
                root = node;
            } else {
                TreeNode peek = stack.peek();
                if (set.contains(peek)) {
                    peek.right = node;
                    stack.pop();
                    if (node != null) {
                        stack.push(node);

                    }
                } else {
                    set.add(peek);
                    peek.left = node;
                    if (node != null) {
                        stack.push(node);
                    }
                }

            }
        }
        return root;
    }
}
