package medium;

import basic.TreeNode;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
// 1080. Insufficient Nodes in Root to Leaf Paths

class lc1080 {
    private Set<TreeNode> set = new HashSet<>();
    private Map<TreeNode, Integer> map = new HashMap<>();
    private Map<TreeNode, Integer> map2 = new HashMap<>();
    private Map<TreeNode, TreeNode> parent = new HashMap<>();
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        map.put(root, root.val);
        parent.put(root, null);
        visit(root);
        return sufficient(root, limit);
    }

    private TreeNode sufficient(TreeNode root, int limit) {
        if (root == null) return null;
        if (map2.get(root) < limit) return null;
        root.left = sufficient(root.left, limit);
        root.right = sufficient(root.right, limit);
        return root;
    }

    private void visit(TreeNode root) {
        if (set.contains(root)) {
            if (root.left == null && root.right == null) {
                int v = map.get(root);
                TreeNode node = parent.get(root);
                while (node != null) {
                    if (map2.get(node) != null) {
                        if (v > map2.get(node)) {
                            map2.put(node, v);
                        }
                    } else {
                        map2.put(node, v);
                    }
                    node = parent.get(node);
                }
            }
        } else {
            set.add(root);
            if (root.left != null) {
                map.put(root.left, root.left.val + map.get(root));
                parent.put(root.left, root);
                visit(root.left);
            }
            if (root.right != null) {
                map.put(root.right, root.right.val + map.get(root));
                parent.put(root.right, root);
                visit(root.right);
            }
            visit(root);
        }
    }

    public TreeNode sufficientSubset2(TreeNode root, int limit) {
        if (root == null) return null;
        boolean reserved = sufficient(root, 0, limit);
        if (reserved) return root;
        return null;
    }
    
    private boolean sufficient(TreeNode root, int sum, int limit) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum + root.val >= limit;
        }
        boolean resLeft = sufficient(root.left, sum + root.val, limit);
        boolean resRight = sufficient(root.right, sum + root.val, limit);
        if (!resLeft) {
            root.left = null;
        }
        if (!resRight) {
            root.right = null;
        }
        return resLeft || resRight;
    }
}