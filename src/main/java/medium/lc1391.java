package medium;

// https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid/
// 1391. 检查网络中是否存在有效路径

public class lc1391 {
    public boolean hasValidPath(int[][] grid) {
        int[][] mapper = new int[][]{
                new int[]{0, -1, 2},
                new int[]{0, 1, 3},
                new int[]{-1, 0, 0},
                new int[]{1, 0, 1},
                new int[]{0, -1, 2},
                new int[]{1, 0, 1},
                new int[]{1, 0, 1},
                new int[]{0, 1, 3},
                new int[]{0, -1, 2},
                new int[]{-1, 0, 0},
                new int[]{-1, 0, 0},
                new int[]{0, 1, 3}
        };

        boolean[][] valid = new boolean[][]{
                new boolean[]{false, false, true, true, true, false, false},
                new boolean[]{false, false, true, false, false, true, true},
                new boolean[]{false, true, false, false, true, false, true},
                new boolean[]{false, true, false, true, false, true, false}
        };

        for (int i = 0; i < 3; i++) {
            boolean ret = dfs(grid, 0, 0, i, new boolean[grid.length][grid[0].length], mapper, valid);
            if (ret) {
                return ret;
            }
        }
        return false;
    }

    private boolean dfs(int[][] grid, int i, int j, int value, boolean[][] visited, int[][] mapper, boolean[][] valid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j]) {
            return false;
        }

        int v = grid[i][j];
        if (!valid[value][v]) {
            return false;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean ret1 = dfs(grid, mapper[2 * v - 1][0] + i, mapper[2 * v - 1][1] + j, mapper[2 * v - 1][2], visited, mapper, valid);
        if (ret1) {
            return true;
        }
        ret1 = dfs(grid, mapper[2 * v - 2][0] + i, mapper[2 * v - 2][1] + j, mapper[2 * v - 2][2], visited, mapper, valid);
        return ret1;

    }
}
