package hard;

// https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
// 1269. 停在原地的方案数

public class lc1269 {
    public int numWays(int steps, int arrLen) {
        int f = 1000000007;
        int m = steps + 1;
        int n = Math.min(arrLen - 1, steps);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < m; i++) {
            int[] dp2 = new int[n + 1];
            for (int j = 0; j < n + 1; j++) {
                dp2[j] = (dp[j]) % f;
                if (j > 0) {
                    dp2[j] = (dp2[j] + dp[j - 1]) % f;
                }
                if (j != n) {
                    dp2[j] = (dp2[j] + dp[j + 1]) % f;
                }
            }
            dp = dp2;
        }
        return dp[0];
    }
}
