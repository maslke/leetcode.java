package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/coloring-a-border/
// 1034. 边界着色
public class lc1034 {
    List<int[]> borders = new ArrayList<>();

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[row][col] = true;
        bfs(grid, row, col, grid[row][col], visited);
        for (int[] pair : borders) {
            grid[pair[0]][pair[1]] = color;
        }
        return grid;
    }

    private void bfs(int[][] grid, int row, int col, int color, boolean[][] visited) {
        boolean border = false;
        int[][] pairs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] p : pairs) {
            int x = row + p[0];
            int y = col + p[1];
            if (!(x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1 && color == grid[x][y])) {
                border = true;
            }
            else if (!visited[x][y]) {
                visited[x][y] = true;
                bfs(grid, x, y, color, visited);
            }
        }
        if (border) {
            borders.add(new int[]{row, col});
        }
    }
}
