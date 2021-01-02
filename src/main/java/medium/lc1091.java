package medium;

// https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
// 1091. 二进制矩阵中的最短路径

import java.util.LinkedList;
import java.util.Queue;

public class lc1091 {
    private boolean valid(int[][] grid, int length, int i, int j, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < length && j < length && grid[i][j] == 0 && !visited[i][j];
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        if (grid[0][0] == 1 || grid[length - 1][length - 1] == 1) {
            return -1;
        }
        int path = 0;
        int[][] diff = new int[][]{new int[]{-1, -1}, new int[] {0, -1}, new int[]{1, -1},
                new int[]{-1, 0}, new int[]{1, 0}, new int[]{-1, 1}, new int[]{0, 1}, new int[]{1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[length][length];
        visited[0][0] = true;
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                int row = p[0];
                int col = p[1];
                if (row == length - 1 && col == length - 1) {
                    return path;
                }

                for (int[] ints : diff) {
                    if (valid(grid, length, row + ints[0], col + ints[1], visited)) {
                        visited[row + ints[0]][col + ints[1]] = true;
                        queue.offer(new int[]{row + ints[0], col + ints[1]});
                    }
                }
            }
        }
        return -1;
    }
}
