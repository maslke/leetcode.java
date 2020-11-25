package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc16_19 {
    int count = 0;
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    count = 0;
                    dfs(land, i, j, visited);
                    list.add(count);
                }
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != 0  || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        count++;
        dfs(grid,i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i - 1, j - 1, visited);
        dfs(grid, i + 1, j + 1, visited);
        dfs(grid, i + 1, j - 1, visited);
        dfs(grid, i - 1, j + 1, visited);
    }
}
