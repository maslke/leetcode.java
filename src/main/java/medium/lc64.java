package medium;

/**
 * Author:maslke
 * Date:2017/8/30
 * Version:0.0.1
 */
public class lc64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] values = new int[row][column];
        values[row - 1][column - 1] = grid[row - 1][column - 1];
        for (int i = column - 2; i >= 0; i--) {
            values[row - 1][i] = grid[row - 1][i] + values[row - 1][i + 1];
        }
        for (int i = row - 2; i >= 0; i--) {
            values[i][column - 1] = grid[i][column - 1] + values[i + 1][column - 1];
        }
        for (int i = row - 2; i >=0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                values[i][j] = grid[i][j] + Math.min(values[i + 1][j], values[i][j + 1]);
            }
        }
        return values[0][0];
    }
}
