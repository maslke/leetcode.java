package medium;

// https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/
// 255. 验证前序遍历序列二叉搜索树

class lc255 {
    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1);
    }

    private boolean verify(int[] preorder, int begin, int end) {
        if (begin > end)
            return true;
        int v = preorder[begin];
        int m = begin + 1;
        while (m <= end) {
            if (preorder[m] > v) {
                break;
            } else {
                m++;
            }
        }
        for (int i = begin + 1; i < m; i++) {
            if (preorder[i] > v)
                return false;
        }
        for (int i = m; i <= end; i++) {
            if (preorder[i] < v)
                return false;
        }
        return verify(preorder, begin + 1, m - 1) && verify(preorder, m, end);
    }
}