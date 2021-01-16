package medium;

// https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
// 990. 等式方程的可满足性

import java.util.ArrayList;
import java.util.List;

public class lc990 {
    public boolean equationsPossible(String[] equations) {
        List<Integer> notEquals = new ArrayList<>();
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            char c = equation.charAt(1);
            int a = equation.charAt(0) - 97;
            int b = equation.charAt(3) - 97;
            if (c == '=') {
                unionFind.union(a, b);
            } else {
                notEquals.add(a);
                notEquals.add(b);
            }
        }

        for (int i = 0; i < notEquals.size(); i = i + 2) {
            if (unionFind.connected(notEquals.get(i), notEquals.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private static class UnionFind {
        int size;
        int[] sz;
        int[] f;

        UnionFind(int size) {
            this.size = size;
            this.sz = new int[this.size];
            this.f = new int[this.size];

            for (int i = 0; i < this.size; i++) {
                this.sz[i] = 1;
                this.f[i] = i;
            }
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
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
            if (sz[pRoot] < sz[qRoot]) {
                sz[qRoot] += sz[pRoot];
                f[pRoot] = qRoot;
            } else {
                sz[pRoot] += sz[qRoot];
                f[qRoot] = pRoot;
            }
        }
    }
}
