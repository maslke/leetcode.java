package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
// 1319. 连通网络的操作次数

public class lc1319 {
    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] connection : connections) {
            unionFind.union(connection[0], connection[1]);
        }

        int count = unionFind.getCount();
        if (count == 1) {
            return 0;
        }

        int left = unionFind.getLeft();

        if (count - 1 > left) {
            return -1;
        }
        return count - 1;


    }

    private class UnionFind {
        private int[] f;
        private int[] rank;
        private int count;
        private int left;

        UnionFind(int n) {
            this.f = new int[n];
            this.rank = new int[n];
            this.count = n;
            this.left = 0;
            Arrays.fill(rank, 1);
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

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                this.left++;
                return;
            }
            this.count--;
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
            return this.count;
        }

        int getLeft() {
            return this.left;
        }

    }
}
