package medium;

import java.util.HashMap;
import java.util.Map;

class lc1120 {
    private Map<TreeNode, Integer> map1 = new HashMap<>();
    private Map<TreeNode, Integer> map2 = new HashMap<>();
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        sum(root);
        count(root);
        return maxAverage(root); 
    }

    private double maxAverage(TreeNode root) {
        if (root == null) return 0;
        return Math.max(average(root), Math.max(maxAverage(root.left), maxAverage(root.right))); 
 
    }

    private double average(TreeNode node) {
        if (node == null) return 0;
        return 1.0 * map1.get(node) / map2.get(node);
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        if (map1.containsKey(node)) return map1.get(node);
        int s1 = 0;
        if (node.left != null) {
            s1 = sum(node.left);
            map1.put(node.left, s1);
        }
        int s2 = 0;
        if (node.right != null) {
            s2 = sum(node.right);
            map1.put(node.right, s2);
        }
        int ret = node.val + s1 + s2;
        map1.put(node, ret);
        return ret;
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        if (map2.containsKey(node)) return map2.get(node);
        int s1 = 0;
        if (node.left != null) {
            s1 = count(node.left);
            map2.put(node.left, s1);
        }
        int s2 = 0;
        if (node.right != null) {
            s2 = count(node.right);
            map2.put(node.right, s2);
        }
        int ret = 1 + s1 + s2;
        map2.put(node, ret);
        return ret;
    }
}