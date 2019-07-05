package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
// 973. K Closest Points to Origin

class lc973 {
    public int[][] kCloset(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
            }
        });

        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
        }

        int[][] result = new int[K][2];
        int index = 0;
        while (K-- > 0) {
            result[index++] = queue.poll();
        }
        return result;
    }
}