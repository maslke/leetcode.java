package medium;

import basic.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

// https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
// 987. 二叉树的垂序遍历

class lc987 {
    private TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>();
    Comparator<int[]> comparator;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        comparator = (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[2] - o2[2];
            }
            return o1[0] - o2[0];
        };
        traversal(root, 0, 0);

        List<List<Integer>> ret = new ArrayList<>();

        for (PriorityQueue<int[]> queue : map.values()) {
            List<Integer> ls = new ArrayList<>();
            while (!queue.isEmpty()) {
                ls.add(queue.poll()[2]);
            }
            ret.add(ls);
        }
        return ret;
    }

    private void traversal(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        int[] p = new int[] {row, col, node.val};
        if (map.containsKey(p[1])) {
            map.get(p[1]).offer(p);
        } else {
            PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
            queue.offer(p);
            map.put(p[1], queue);
        }


        traversal(node.left, row + 1, col - 1);
        traversal(node.right, row + 1, col + 1);
    }
}