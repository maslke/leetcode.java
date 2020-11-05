package medium;

import basic.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// 987. Vertical Order Traversal of a Binary Tree

class lc987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<Integer, List<TreeNode>> map = new TreeMap<>();
        Map<TreeNode, List<Integer>> map2 = new HashMap<>();
        List<Integer> xy = new ArrayList<>();
        xy.add(0);
        xy.add(0);
        map2.put(root, xy);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                List<Integer> xys = map2.get(node);
                if (map.containsKey(xys.get(0))) {
                    map.get(xys.get(0)).add(node);
                } else {
                    List<TreeNode> list = new ArrayList<>();
                    list.add(node);
                    map.put(xys.get(0), list);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    List<Integer> xy1 = new ArrayList<>();
                    xy1.add(xys.get(0) - 1);
                    xy1.add(xys.get(1) - 1);
                    map2.put(node.left, xy1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    List<Integer> xy2 = new ArrayList<>();
                    xy2.add(xys.get(0) + 1);
                    xy2.add(xys.get(1) - 1);
                    map2.put(node.right, xy2);
                }
            }
        }
        for (List<TreeNode> list : map.values()) {
            Collections.sort(list, new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode a, TreeNode b) {
                    if (map2.get(a).get(1) == map2.get(b).get(1)) {
                        return a.val - b.val;
                    } else {
                        return 0;
                    }
                }
            });
            List<Integer> values = new ArrayList<>();
            for (TreeNode node : list) {
                values.add(node.val);
            }
            ret.add(values);
        }
        return ret;
    }
}