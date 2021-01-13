package medium;

// https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
// 947. 移除最多的同行或同列石头

public class lc947 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[stones.length];
        int ret = 0;
        for (int i = 0; i < stones.length; i++) {
            if (visited[i]) {
                continue;
            }
            ret += dfs(stones, i, visited, new boolean[10001], new boolean[10001]);
            ret--;
        }
        return ret;
    }

    private int dfs(int[][] stones, int begin, boolean[] visited, boolean[] rows, boolean[] cols) {
        visited[begin] = true;
        rows[stones[begin][0]] = true;
        cols[stones[begin][1]] = true;
        int ret = 1;

        for (int i = 0; i < stones.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (rows[stones[i][0]] || cols[stones[i][1]]) {
                ret += dfs(stones, i, visited, rows, cols);
            }
        }
        return ret;

    }
}
