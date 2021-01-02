package medium;

// https://leetcode-cn.com/problems/path-with-maximum-gold/
// 1219. 黄金矿工

public class lc1219 {
    public int getMaximumGold(int[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    int count = dfs(grid, i, j);
                    ret = Math.max(count, ret);
                }
            }
        }

        return ret;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        int count = grid[i][j];
        int prev = grid[i][j];
        grid[i][j] = 0;
        int count1 = dfs(grid, i + 1, j);
        int count2 = dfs(grid, i - 1, j);
        int count3 = dfs(grid, i, j + 1);
        int count4 = dfs(grid, i, j - 1);
        grid[i][j] = prev;

        return count + Math.max(Math.max(count1, count2), Math.max(count3, count4));
    }
}
