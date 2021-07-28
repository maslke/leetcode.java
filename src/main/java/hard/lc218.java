package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode-cn.com/problems/the-skyline-problem/
// 218. 天际线问题

public class lc218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ret = new ArrayList<>();
        List<int[]> values = new ArrayList<>();
        for (int[] bld : buildings) {
            values.add(new int[]{bld[0], -bld[2]});
            values.add(new int[]{bld[1], bld[2]});
        }

        values.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            else {
                return a[0] - b[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(0);
        for (int[] v : values) {
            int x = v[0];
            int h = v[1];

            if (h < 0) {
                queue.offer(-h);
            }
            else {
                queue.remove(h);
            }
            int height = queue.peek();
            if (ret.isEmpty() || height != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(x, height));
            }
        }

        return ret;
    }
}
