package medium;

import java.util.Arrays;
// https://leetcode-cn.com/problems/regions-cut-by-slashes/
// 959. 由斜杠划分区域

class lc959 {
    private class UnionFind {
        private int count;
        private int[] f;
        private int[] rank;

        UnionFind(int n) {
            f = new int[n];
            rank = new int[n];
            count = n;

            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        int find(int x) {
            while (x != f[x]) {
                x = f[x];
            }
            return x;
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            count--;
            if (rank[pRoot] > rank[qRoot]) {
                rank[pRoot] += rank[qRoot];
                f[qRoot] = pRoot;
            }
            else {
                rank[qRoot] += rank[pRoot];
                f[pRoot] = qRoot;
            }
        }

        int getCount() {
            return count;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind unionFind = new UnionFind(4 * n * n);
        for (int i = 0; i < n; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int inx = 4 * (i * n + j);

                char c = chars[j];

                if (c == '/') {
                    unionFind.union(inx, inx + 3);
                    unionFind.union(inx + 1, inx + 2);
                }
                else if (c == '\\') {
                    unionFind.union(inx, inx + 1);
                    unionFind.union(inx + 2, inx + 3);

                }
                else {
                    unionFind.union(inx, inx + 1);
                    unionFind.union(inx, inx + 2);
                    unionFind.union(inx, inx + 3);
                }

                if (j + 1 < n) {
                    unionFind.union(inx + 1, inx + 7);
                }
                if (i + 1 < n) {
                    unionFind.union(inx + 2, 4 * ((i + 1) * n + j));
                }


            }


        }
        return unionFind.getCount();
    }
}