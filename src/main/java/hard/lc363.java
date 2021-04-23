package hard;

import java.util.TreeSet;

// https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
// 363. 矩形区域不超过 K 的最大数值和
// CV
public class lc363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int[] v = new int[n];
            for (int j = i; j < m; j++) {
                for (int i1 = 0; i1 < n; i1++) {
                    v[i1] += matrix[j][i1];
                }
                TreeSet<Integer> set = new TreeSet<>();
                int s = 0;
                set.add(0);
                for (int value : v) {
                    s += value;
                    Integer ceiling = set.ceiling(s - k);
                    if (ceiling != null) {
                        max = Math.max(max, s - ceiling);
                    }
                    set.add(s);
                }

            }
        }

        return max;
    }
}
