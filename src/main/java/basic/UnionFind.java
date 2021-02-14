package basic;

import java.util.Arrays;

/**
 * UnionFind
 */
public class UnionFind {
    private int count;
    private int[] f;
    private int[] rank;

    public UnionFind(int n) {
        this.count = n;
        this.f = new int[n];
        this.rank = new int[n];
        Arrays.fill(this.rank, 1);
        for (int i = 0; i < n; i++) {
            this.f[i] = i;
        }
    }

    public int find(int x) {
        while (x != f[x]) {
            x = f[x];
        }
        return x;
    }

    public boolean union(int p, int q) {
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

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }

    public int getSize(int p) {
        int pRoot = find(p);
        int size = 0;
        for (int i = 0; i < f.length; i++) {
            if (find(f[i]) == pRoot) {
                size++;
            }
        }
        return size;
    }
}
