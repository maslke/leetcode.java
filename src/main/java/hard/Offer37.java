package hard;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
// 剑指 Offer 37. 序列化二叉树

public class Offer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    sb.append(",").append(node.left.val);
                    queue.offer(node.left);
                }
                else {
                    sb.append(",null");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sb.append(",").append(node.right.val);
                }
                else {
                    sb.append(",null");
                }
            }
        }
        String[] parts = sb.toString().split(",");
        int inx = -1;
        for (int i = parts.length - 1; i >= 0; i--) {
            if (!parts[i].equals("null")) {
                inx = i;
                break;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i <= inx; i++) {
            sb2.append(",").append(parts[i]);
        }
        return sb2.substring(1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] parts = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int inx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                inx++;
                if (inx >= parts.length) {
                    break;
                }
                if (parts[inx].equals("null")) {
                    node.left = null;
                }
                else {
                    node.left = new TreeNode(Integer.parseInt(parts[inx]));
                    queue.offer(node.left);
                }
                inx++;
                if (inx >= parts.length) {
                    break;
                }
                if (parts[inx].equals("null")) {
                    node.right = null;
                }
                else {
                    node.right = new TreeNode(Integer.parseInt(parts[inx]));
                    queue.offer(node.right);
                }
            }

        }
        return root;
    }
}
