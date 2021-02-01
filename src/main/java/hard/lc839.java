package hard;

import basic.UnionFind;

// https://leetcode-cn.com/problems/similar-string-groups/
// 839. 相似字符串组

public class lc839 {
    public int numSimilarGroups(String[] strs) {

        int len = strs[0].length();
        UnionFind uf = new UnionFind(strs.length);

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (uf.connected(i, j)) {
                    continue;
                }
                if (valid(strs[i], strs[j], len)) {
                    uf.union(i, j);
                }
            }
        }



        return uf.getCount();
    }

    private boolean valid(String a, String b, int len) {
        if (a.equals(b)) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
