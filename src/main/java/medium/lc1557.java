package medium;

// https://leetcode-cn.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
// 1557. 可以到达所有点的最少点数目

import java.util.ArrayList;
import java.util.List;

public class lc1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] flag = new boolean[n];
        for (List<Integer> edge : edges) {
            flag[edge.get(1)] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                list.add(i);
            }
        }

        return list;
    }
}
