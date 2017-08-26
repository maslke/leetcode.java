package medium;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 62. Unique Paths
 */
public class lc62 {
    public int uniquePaths(int m, int n) {
        int[][] values = new int[m][n];
        for (int i = 0; i < n; i++) {
            values[m - 1][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            values[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                values[i][j] = values[i][j + 1] + values[i + 1][j];
            }
        }
        return values[0][0];
    }
}
