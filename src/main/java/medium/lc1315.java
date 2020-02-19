package medium;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class lc1315 {
    public int sumEvenGrandparent2(TreeNode root) {
        return helper(root, 1);
    }

    private int helper(TreeNode node, int value) {
        if (node == null) return 0;
        int val = 0;
        if (value % 2 == 0) {
            if (node.left != null) {
                val += node.left.val;
            }
            if (node.right != null) {
                val += node.right.val;
            }
        }
        return val + helper(node.left, node.val) + helper(node.right, node.val);
    }

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (map.containsKey(node) && map.containsKey(map.get(node)) && map.get(map.get(node)).val % 2 == 0) {
                    sum += node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map.put(node.right, node);
                }
            }
        }
        return sum;
    }
}