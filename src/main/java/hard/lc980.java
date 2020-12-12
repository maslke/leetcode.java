package hard;

// https://leetcode-cn.com/problems/unique-paths-iii/
// 980. 不同路径III
public class lc980 {
    private int ret;
    public int uniquePathsIII(int[][] grid) {
        ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i + 1, j);
                    dfs(grid, i - 1, j);
                    dfs(grid, i, j + 1);
                    dfs(grid, i, j - 1);
                    break;
                }
            }
        }

        return ret;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }

        if (grid[i][j] == 1 || grid[i][j] == -1 || grid[i][j] == 3) {
            return;
        }
        if (grid[i][j] == 2) {
            if (check(grid)) {
                ret++;
            }
            return;
        }
        grid[i][j] = 3;
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        grid[i][j] = 0;
    }

    private boolean check(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lc980 instance = new lc980();
        int[][] grid = new int[][]{new int[]{1,0,0,0},new int[]{0,0,0,0},new int[]{0,0,2,-1}};
        int ret = instance.uniquePathsIII(grid);
    }
}
