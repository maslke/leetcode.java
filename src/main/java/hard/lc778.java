package hard;

import basic.UnionFind;

public class lc778 {

    public int swimInWater2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(m * n);

        int[] val = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                val[grid[i][j]] = i * n + j;
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m * n; i++) {
            int x = val[i] / n;
            int y = val[i] % n;
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] < i) {
                    uf.union(val[i], newX * n + newY);
                }
            }

            if (uf.connected(0, m * n - 1)) {
                return i;
            }
        }
        return -1;

    }


    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(m * n);

        int cur = 0;
        while (true) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > cur) {
                        continue;
                    }
                    if (j < n - 1 && grid[i][j + 1] <= cur) {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                    if (i < m - 1 && grid[i + 1][j] <= cur) {
                        uf.union(i * n + j, i * n + n + j);
                    }

                    if (uf.connected(0, m * n - 1)) {
                        return cur;
                    }

                }
            }
            cur++;
        }
    }
}
