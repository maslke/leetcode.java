package medium;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 63. Unique Paths II
 */
public class lc63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] values = new int[m][n];
        values[ m - 1][n - 1] = Math.abs(1 - obstacleGrid[m - 1][n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1 || values[m - 1][i + 1] == 0) {
                values[m - 1][i] = 0;
            } else {
                values[m - 1][i] = 1;
            }
        }
        for (int i = m - 2; i >= 0 ; i--) {
            if (obstacleGrid[i][n - 1] == 1 || values[i + 1][n - 1] == 0) {
                values[i][n - 1] = 0;
            } else {
                values[i][n - 1] = 1;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    values[i][j] = 0;
                } else {
                    values[i][j] = values[i + 1][j] + values[i][j + 1];
                }
            }
        }
        return values[0][0];

    }
}
