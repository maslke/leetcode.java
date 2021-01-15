package medium;

// https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
// 947. 移除最多的同行或同列石头

import java.util.Arrays;

public class lc947 {
    public int removeStones2(int[][] stones) {
        UnionFind uf = new UnionFind();
        int n = stones.length;
        for (int[] stone : stones) {
            uf.connect(stone[0] + 10000, stone[1]);
        }
        return n - uf.getCount();
    }

    static class UnionFind {

        int[] v;
        int[] sz;

        int count;

        UnionFind() {
            v = new int[20001];
            for (int i = 0; i < 20001; i++) {
                v[i] = i;
            }
            sz = new int[20001];
            Arrays.fill(sz, -1);
            count = 0;
        }

        int getCount() {
            return count;
        }

        int find(int x) {
            if (sz[x] == -1) {
                sz[x] = 1;
                count++;
            }
            while (v[x] != x) {
                x = v[x];
            }
            return x;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        void connect(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (sz[pRoot] > sz[qRoot]) {
                v[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            } else {
                v[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            }
            count--;
        }
    }

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
