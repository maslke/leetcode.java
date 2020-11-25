package easy;

// https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
// 892. 三维形体的表面积

class lc892 {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    sum += grid[i][j] * 4 + 2;
                }
                if (i > 0) {
                    sum -= Math.min(grid[i - 1][j], grid[i][j]) * 2;
                }

                if (j > 0) {
                    sum -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
                }
            }
        }
        return sum;
    }
}