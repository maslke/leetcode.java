package medium;

// https://leetcode.com/problems/integer-break/
// 343. Integer Break

class lc343 {
    public int integerBreak(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int[] ret = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                ret[i] = Math.max(ret[i], ret[j] * (i - j));
                ret[i] = Math.max(ret[i], j * (i - j));
            }
        }

        return ret[n];
    }
}