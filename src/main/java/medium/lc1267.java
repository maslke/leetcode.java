package medium;

// https://leetcode-cn.com/problems/count-servers-that-communicate/
// 1267. 统计参与通信的服务器

public class lc1267 {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
                if (sum >= 2) {
                    rows[i] = 1;
                    break;
                }
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            int sum = 0;
            for (int[] aGrid : grid) {
                sum += aGrid[j];
                if (sum >= 2) {
                    cols[j] = 1;
                    break;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (rows[i] == 1 || cols[j] == 1)) {
                    ret++;
                }
            }
        }

        return ret;
    }
}
