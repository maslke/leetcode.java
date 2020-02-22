package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode-cn.com/problems/find-leaves-of-binary-tree/
// 366. 寻找完全二叉树的叶子节点 

class lc366 {
    private Map<TreeNode, Integer> child = new LinkedHashMap<>();
    private Map<TreeNode, TreeNode> parent = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        parent.put(root, null);
        group(root);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Set<TreeNode> set = new HashSet<>();
        while (true) {
            List<Integer> list = new ArrayList<>();
            Map<TreeNode, Integer> child2 = new LinkedHashMap<>(child);
            for (Map.Entry<TreeNode, Integer> entry : child.entrySet()) {
                TreeNode node = entry.getKey();
                int cnt = entry.getValue();
                if (cnt == 0 && !set.contains(node)) {
                        set.add(node);
                        list.add(node.val);
                        if (parent.get(node) == null) {
                            break;
                        } else {
                            int count = child2.get(parent.get(node));
                            child2.put(parent.get(entry.getKey()), count - 1);
                        }
                    }
            }
            if (list.isEmpty()) break;
            child = new LinkedHashMap<>(child2);
            result.add(list);
            }
            return result;
        
           
    }

    private void group(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            child.put(root, 0);
        }
        if (root.left != null) {
            parent.put(root.left, root);
            child.put(root, child.getOrDefault(root, 0) + 1);
            group(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            child.put(root, child.getOrDefault(root, 0) + 1);
            group(root.right);
        }
    }
}