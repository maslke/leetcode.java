package easy;

/**
 * Author:maslke
 * Date:2017/9/17
 * Version:0.0.1
 * 463. Island Perimeter
 */
public class lc463 {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    count1 += 1;
                }
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        count2++;
                    }
                    if (i + 1 < row && grid[i + 1][j] == 1) {
                        count2++;
                    }
                    if (j + 1 < column && grid[i][j + 1] == 1) {
                        count2++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        count2++;
                    }
                }
            }
        }
        return count1 * 4 - count2;
    }
}
