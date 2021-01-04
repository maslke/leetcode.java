package medium;

// https://leetcode-cn.com/problems/number-of-closed-islands/
// 1254. 统计封闭岛屿的数量

public class lc1254 {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    boolean ret = dfs(grid, i, j, visited);
                    if (!ret) {
                        count++;
                    }
                }
            }
        }
        return count;

    }

    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return false;
        }
        if (visited[i][j] || grid[i][j] == 1) {
            return false;
        }
        boolean ret = false;
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
            ret = true;
        }

        visited[i][j] = true;
        boolean ret1 = dfs(grid, i - 1, j, visited);
        boolean ret2 = dfs(grid, i + 1, j, visited);
        boolean ret3 = dfs(grid, i, j - 1, visited);
        boolean ret4 = dfs(grid, i, j + 1, visited);

        return ret || ret1 || ret2 || ret3 || ret4;

    }
}
