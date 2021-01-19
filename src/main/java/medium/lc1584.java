package medium;

// https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
// 1584. 连接所有点的最小费用

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc1584 {
    int[][] edges;
    boolean[] visited;
    PriorityQueue<int[]> queue;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        edges = new int[n][n];
        int sum = 0;

        queue = new PriorityQueue<int[]>(Comparator.comparingInt(a -> edges[a[0]][a[1]]));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                edges[i][j] = d;
                edges[j][i] = d;
            }
        }

        visited = new boolean[n];
        visit(0);
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            if (visited[a[0]] && visited[a[1]]) {
                continue;
            }
            sum += edges[a[0]][a[1]];
            if (!visited[a[0]]) {
                visit(a[0]);
            }
            if (!visited[a[1]]) {
                visit(a[1]);
            }
        }
        return sum;

    }

    private void visit(int start) {
        visited[start] = true;
        for (int i = 0; i < edges[start].length; i++) {
            if (edges[start][i] != 0 && !(visited[i])) {
                queue.offer(new int[]{start, i});
            }
        }
    }
}
