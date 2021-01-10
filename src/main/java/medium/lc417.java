package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
// 417. 太平洋大西洋水流问题

public class lc417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        int m = matrix.length;
        if (m == 0 || matrix[0].length == 0) {
            return ret;
        }
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] visited2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && (i == 0 || j == 0)) {
                    dfs(matrix, i, j, matrix[i][j], visited);
                }
                if (!visited2[i][j] && (i == m - 1 || j == n - 1)) {
                    dfs(matrix, i, j, matrix[i][j], visited2);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] && visited2[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }
        return ret;
    }


    private void dfs(int[][] matrix, int i, int j, int before, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length) {
            return;
        }
        if (visited[i][j] || matrix[i][j] < before) {
            return;
        }
        visited[i][j] = true;
        dfs(matrix, i + 1, j, matrix[i][j], visited);
        dfs(matrix, i - 1, j , matrix[i][j], visited);
        dfs(matrix, i, j + 1, matrix[i][j], visited);
        dfs(matrix, i, j - 1, matrix[i][j], visited);
    }
}
