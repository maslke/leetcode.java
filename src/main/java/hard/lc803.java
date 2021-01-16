package hard;

// https://leetcode-cn.com/problems/bricks-falling-when-hit/
// 803. 打砖块

public class lc803 {
    private int rows;
    private int cols;
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


    public int[] hitBricks(int[][] grid, int[][] hits) {

        this.rows = grid.length;
        this.cols = grid[0].length;
        int size = rows * cols;

        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, cols);
        }

        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        UnionFind uf = new UnionFind(size + 1);
        for (int i = 0; i < cols; i++) {
            if (copy[0][i] == 1) {
                uf.connect(i, size);
            }
        }

        int[] ret = new int[hits.length];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int inx = getIndex(i, j);
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        uf.connect(inx, getIndex(i - 1, j));
                    }
                    if (j > 0 && copy[i][j - 1] == 1) {
                        uf.connect(inx, getIndex(i, j - 1));
                    }
                }
            }
        }


        for (int i = hits.length - 1; i >= 0; i--) {

            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) {
                continue;
            }

            int inx = getIndex(x, y);


            int s1 = uf.getSize(size);

            if (x == 0) {
                uf.connect(y, size);
            }

            for (int[] d : DIRECTIONS) {
                int a = x + d[0];
                int b = y + d[1];

                if (valid(a, b) && copy[a][b] == 1) {
                    uf.connect(getIndex(a, b), inx);
                }
            }

            int s2 = uf.getSize(size);
            ret[i] = Math.max(0, s2 - s1 - 1);
            copy[x][y] = 1;
        }

        return ret;
    }

    private boolean valid(int a, int b) {
        return a >= 0 && a < rows && b >= 0 && b < cols;
    }

    private int getIndex(int i, int j) {
        return i * cols + j;
    }

    private static class UnionFind {
        int[] f;
        int[] sz;
        int size;

        UnionFind(int size) {
            this.size = size;
            f = new int[this.size];
            sz = new int[this.size];

            for (int i = 0; i < this.size; i++) {
                f[i] = i;
                sz[i] = 1;
            }
        }

        int find(int x) {
            while (x != f[x]) {
                x = f[x];
            }
            return x;
        }

        void connect(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (sz[qRoot] > sz[pRoot]) {
                sz[qRoot] += sz[pRoot];
                f[pRoot] = qRoot;
            } else {
                sz[pRoot] += sz[qRoot];
                f[qRoot] = pRoot;
            }
        }

        int getSize(int index) {
            int root = find(index);
            return sz[root];
        }
    }
}
