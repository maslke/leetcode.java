package easy;

// https://leetcode-cn.com/problems/transpose-matrix/
// 867. 转置矩阵

public class lc867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ret = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = matrix[j][i];
            }
        }
        return ret;
    }
}
