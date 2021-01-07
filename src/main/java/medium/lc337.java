package medium;

import basic.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/house-robber-iii/submissions/
// 337. 打家劫舍 III

public class lc337 {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int left = rob(root.left);
        map.put(root.left, left);
        int right = rob(root.right);
        map.put(root.right, right);

        int v = left + right;

        int v2 = root.val;
        if (root.left != null) {
            left = rob(root.left.left);
            map.put(root.left.left, left);
            right = rob(root.left.right);
            map.put(root.left.right, right);
            v2 += left + right;
        }
        if (root.right != null) {
            left = rob(root.right.left);
            map.put(root.right.left, left);
            right = rob(root.right.right);
            map.put(root.right.right, right);
            v2 += left + right;
        }
        int ret = Math.max(v, v2);
        map.put(root, ret);
        return ret;
    }
}
