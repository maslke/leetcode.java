package medium;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class lc1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxValue = Integer.MIN_VALUE;
        int level = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
            }
            if (sum > maxValue) {
                result = level;
                maxValue = sum;
            }
        }
        return result;
    }
}