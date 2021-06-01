package hard;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/
// 1074. 元素和为目标值的子矩阵数量
public class lc1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] acc = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] + matrix[i - 1][j - 1] - acc[i - 1][j - 1];
            }
        }

        int count = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {

                Map<Integer, Integer> map = new HashMap<>();
                for (int k = 1; k <= n; k++) {
                    int v = acc[j][k] - acc[i - 1][k];
                    if (v == target) {
                        count++;
                    }
                    if (map.containsKey(v - target)) {
                        count += map.get(v - target);
                    }
                    map.put(v, map.getOrDefault(v, 0) + 1);
                }


            }
        }

        return count;
    }
}
