package medium;

// https://leetcode-cn.com/problems/network-delay-time/
// 743. 网络延迟时间

import java.util.Arrays;

public class lc743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE / 2);
        }
        for (int[] t : times) {
            matrix[t[0] - 1][t[1] - 1] = t[2];
        }

        boolean[] used = new boolean[N];

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[K - 1] = 0;
        for (int i = 0; i < N; i++) {
            int x = -1;
            for (int y = 0; y < N; y++) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;

            for (int j = 0; j < N; j++) {
                dist[j] = Math.min(dist[j], matrix[x][j] + dist[x]);
            }


        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dist[i]);
        }
        return max == Integer.MAX_VALUE / 2 ? -1 : max;

    }
}
