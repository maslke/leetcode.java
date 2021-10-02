package easy;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Author:maslke
 * Date:2017/9/10
 * Version:0.0.1
 * 437. Path Sum III
 */
public class lc437 {

    public int pathSum2(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return dfs(root, map, 0, targetSum);
    }

    private int dfs(TreeNode node, Map<Integer, Integer> map, int current, int target) {
        if (node == null) {
            return 0;
        }
        int val = current + node.val;

        int ret = map.getOrDefault(val - target, 0);
        map.put(val, map.getOrDefault(val, 0) + 1);
        ret += dfs(node.left, map, val, target);
        ret += dfs(node.right, map, val, target);
        map.put(val, map.getOrDefault(val, 0) - 1);
        return ret;
    }

    public int pathSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        list.add(root.val);
        Map<TreeNode, List<Integer>> map = new HashMap<>();
        map.put(root, list);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            List<Integer> values = map.get(node);
            int sum = 0;
            for (int i = values.size() - 1; i >= 0; i--) {
                sum += values.get(i);
                if (sum == targetSum) {
                    ret++;
                }
            }

            if (node.left != null) {
                List<Integer> values2 = new ArrayList<>(values);
                values2.add(node.left.val);
                map.put(node.left, values2);
                queue.offer(node.left);
            }
            if (node.right != null) {
                List<Integer> values2 = new ArrayList<>(values);
                values2.add(node.right.val);
                map.put(node.right, values2);
                queue.offer(node.right);
            }

        }
        return ret;
    }
}
