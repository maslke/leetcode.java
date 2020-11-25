package medium;

// https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
// 807. 保持城市天际线

public class lc807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // store columns
        int[] rows = new int[grid.length];
        // store rows
        int[] cols = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            int row = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                    row = j;
                }
            }
            rows[i] = row;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            int col = 0;
            for (int j = 0; j < grid.length; j++) {
                if (max < grid[j][i]) {
                    max = grid[j][i];
                    col = j;
                }

            }
            cols[i] = col;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == grid[i][rows[i]] || grid[i][j] == grid[cols[j]][j]) {
                    continue;
                }
                int before = grid[i][j];
                grid[i][j] = Math.min(grid[i][rows[i]], grid[cols[j]][j]);
                count += (grid[i][j] - before);

            }
        }

        return count;
    }
}
