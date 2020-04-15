package medium;

// https://leetcode-cn.com/problems/max-area-of-island/
// 695. 岛屿的最大面积

class lc695 {
    private boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j]) {
                    int count = visit(grid, i, j);
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }
        return max;
    }

    private int visit(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) return 0;
        if (grid[i][j] == 0) return 0;
        if (visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + visit(grid, i + 1, j) + visit(grid, i, j + 1) + visit(grid, i - 1, j) + visit(grid, i, j - 1);
    }

}

