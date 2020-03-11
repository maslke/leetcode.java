package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
// 54. Spiral Matrix


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        int m = 0;
        int n = 0;
        int m1 = matrix.length - 1;
        int n1 = matrix[0].length - 1;
        List<Integer> ret = new ArrayList<>(matrix.length * matrix[0].length);
        while (m <= m1 && n <= n1) {
            for (int i = n; i <= n1; i++) {
                ret.add(matrix[m][i]);
            }

            for (int i = m + 1; i <= m1; i++) {
                ret.add(matrix[i][n1]);
            }

            if (m < m1) {
                for (int i = n1 - 1; i >= n; i--) {
                    ret.add(matrix[m1][i]);
                }
            }

            if (n < n1) {
                for (int i = m1 - 1; i > m; i--) {
                    ret.add(matrix[i][n]);
                }
            }

            m++;
            n++;
            m1--;
            n1--;
        }        
        return ret;
    }
}

