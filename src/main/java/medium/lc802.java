package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegrees = new int[n];
        for (int i = 0; i < graph.length; i++) {
            int[] edge = graph[i];
            for (int e : edge) {
                list.get(e).add(i);

            }
            inDegrees[i] = graph[i].length;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            List<Integer> edges = list.get(v);
            for (Integer e : edges) {
                inDegrees[e]--;
                if (inDegrees[e] == 0) {
                    queue.offer(e);
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                ret.add(i);
            }
        }
        return ret;
    }
}
