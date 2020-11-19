package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// https://leetcode-cn.com/problems/route-between-nodes-lcci/
// 面试题 04.01. 节点间通路

public class lc04_01 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }
        if (start < 0 || target < 0 || start >= n || target > n) {
            return false;
        }
        LinkedList[] edges = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new LinkedList<Integer>();
        }
        for (int[] ints : graph) {
            edges[ints[0]].addLast(ints[1]);
        }
        return dfs(edges, start, target, new HashSet<>());

    }

    private boolean dfs(LinkedList[] edges, int start, int target, Set<Integer> set) {
        LinkedList<Integer> edge = edges[start];
        set.add(start);
        for (Integer node : edge) {
            if (node == target) {
                return true;
            }
            if (set.contains(node)) {
                continue;
            }
            set.add(node);
            boolean ret = dfs(edges, node, target, set);
            if (ret) {
                return true;
            }
            set.remove(node);
        }

        return false;
    }
}
