package medium;

import java.util.Queue;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/ 958. Check
 * Completeness of a Binary Tree Definition for a binary tree node. public class
 * TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x;
 * } }
 */
class lc959 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null || node.right != null) {
                    if (flag)
                        return false;
                }
                if (node.left == null && node.right != null) {
                    return false;
                }
                if (node.left != null && node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else if (node.left != null) {
                    flag = true;
                    queue.add(node.left);
                } else {
                    flag = true;
                }
            }
            if (size < count && !queue.isEmpty())
                return false;
            count *= 2;
        }
        return true;
    }
}