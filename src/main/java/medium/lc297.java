package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/perfect-squares/
// 297. 完全平方数

public class lc297 {
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, n + 1);
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }
}
