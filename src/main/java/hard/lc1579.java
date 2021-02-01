package hard;

// https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
// 1579. 保证图可完全遍历

import java.util.Arrays;

public class lc1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int res = 0;
        for (int i = 0; i < edges.length; i++) {
            edges[i][1]--;
            edges[i][2]--;
        }

        UnionFind unionFind1 = new UnionFind(n);
        UnionFind unionFind2 = new UnionFind(n);

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!unionFind1.union(edge[1], edge[2])) {
                    res++;
                } else
                    unionFind2.union(edge[1], edge[2]);
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!unionFind1.union(edge[1], edge[2])) {
                    res++;
                }
            } else if (edge[0] == 2) {
                if (!unionFind2.union(edge[1], edge[2])) {
                    res++;
                }
            }
        }

        if (unionFind1.getCount() > 1 || unionFind2.getCount() > 1) {
            return -1;
        }
        return res;
    }

    private class UnionFind {
        private int count;
        private int[] f;
        private int[] rank;

        UnionFind(int n) {
            this.count = n;
            this.f = new int[n];
            this.rank = new int[n];

            Arrays.fill(this.rank, 1);
            for (int i = 0; i < n; i++) {
                this.f[i] = i;
            }
        }

        int find(int x) {
            while (x != f[x]) {
                x = f[x];
            }
            return x;
        }

        boolean union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return false;
            }
            if (rank[pRoot] >= rank[qRoot]) {
                rank[pRoot] += rank[qRoot];
                f[qRoot] = pRoot;
            } else {
                rank[qRoot] += rank[pRoot];
                f[pRoot] = qRoot;
            }
            count--;
            return true;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        int getCount() {
            return count;
        }
    }
}
