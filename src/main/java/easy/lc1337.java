package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
// 1337. 矩阵中战斗力最弱的 K 行

class lc1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < mat.length; i++) {
            int pos = -1;
            int[] v = mat[i];
            int low = 0;
            int high = v.length - 1;
            while (low <= high) {
                int m = (high - low) / 2 + low;
                if (v[m] == 1) {
                    pos = m;
                    low = m + 1;
                }
                else {
                    high = m - 1;
                }
            }
            queue.offer(new int[]{i, pos + 1});
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll()[0];
        }
        return ret;

    }
}