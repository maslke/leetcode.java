package hard;

import basic.UnionFind;

// https://leetcode-cn.com/problems/couples-holding-hands/submissions/
// 765. 情侣牵手
public class lc765 {
    public int minSwapsCouples(int[] row) {
        int length = row.length;
        UnionFind uf = new UnionFind(length);
        for (int i = 0; i < row.length; i = i + 2) {
            uf.union(row[i], row[i + 1]);
            if (row[i] % 2 == 0) {
                uf.union(row[i], row[i] + 1);
            } else {
                uf.union(row[i], row[i] - 1);
            }
            if (row[i + 1] % 2 == 0) {
                uf.union(row[i + 1], row[i + 1] + 1);
            } else {
                uf.union(row[i + 1], row[i + 1] - 1);
            }
        }
        int res = 0;
        int[] visited = new int[length];
        for (int i = 0; i < length; i++) {
            int pRoot = uf.find(i);
            visited[pRoot]++;
        }

        for (int j : visited) {
            if (j > 0) {
                res += j / 2 - 1;
            }
        }
        return res;
    }
}
