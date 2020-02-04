package medium;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class lc236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parents.put(root, null);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    parents.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    parents.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }

        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parents.get(p);
        }
        while (q != null) {
            if (set.contains(q)) return q;
            p = parents.get(q);
        }
        return null;
    }
}