package medium;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
// 1123. Lowest Common Ancestor of Deepest Leaves

class lc1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> lastLevels = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean last = true;
            lastLevels.clear();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                lastLevels.add(node);
                if (node.left != null) {
                    last = false;
                    parent.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    last = false;
                    parent.put(node.right, node);
                    queue.offer(node.right);
                }
            }
            if (last) {
                break;
            }
        }
        
        TreeNode p = lastLevels.get(0);
        for (int i = 1; i < lastLevels.size(); i++) {
            p = find(parent, p, lastLevels.get(i));
        }
        
        return p;

    }

    TreeNode find(Map<TreeNode, TreeNode> map, TreeNode p, TreeNode q) {
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (q != null) {
            if (set.contains(q)) return q;
            q = map.get(q);
        }
        return null;
    }
}