package medium;

// https://leetcode-cn.com/problems/redundant-connection/
// 684. 冗余连接

public class lc684 {
    private int[] v;
    private int[] sz;

    private int find(int x) {
        while (x != v[x]) {
            x = v[x];
        }
        return x;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void connect(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] > sz[qRoot]) {
            v[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        else {
            v[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        v = new int[n + 1];
        sz = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            v[i] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            sz[i] = 1;
        }

        int[] ret = null;

        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            if (connected(p, q)) {
                ret = edge;
            }
            else {
                connect(p, q);
            }
        }
        return ret;

    }
}
