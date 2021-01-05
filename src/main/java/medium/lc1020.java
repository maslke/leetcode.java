package medium;

// https://leetcode-cn.com/problems/number-of-enclaves/
// 1020. 飞地的数量

public class lc1020 {
    public int numEnclaves(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int count = 0;
        boolean[][] visited = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            if (A[0][j] == 1) {
                dfs(A, 0, j);
            }
            if (A[m - 1][j] == 1) {
                dfs(A, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (A[i][0] == 1) {
                dfs(A, i, 0);
            }
            if (A[i][n - 1] == 1) {
                dfs(A, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }


        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == 0 || grid[i][j] == -1) {
            return;
        }

        grid[i][j] = -1;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
