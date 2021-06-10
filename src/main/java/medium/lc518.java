package medium;

// https://leetcode-cn.com/problems/coin-change-2/
// 518. 零钱兑换 II
public class lc518 {
    public int change(int amount, int[] coins) {
        // dp[i][j] 表示用前面i个coin可以凑成 j金额的方案个数
        // dp[conins.length][amount]就表示用全体coins可以凑成amount的个数
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[length][amount];
    }

    public int change2(int amount, int[] coins) {
        int length = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= amount; j++) {

                if (j >= coins[i - 1]) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }

            }
        }
        return dp[amount];
    }
}
