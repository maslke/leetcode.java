package medium;

// https://leetcode-cn.com/problems/last-stone-weight-ii/
// 1049. 最后一块石头的重量 II

public class lc1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int length = stones.length;

        boolean[][] dp = new boolean[length + 1][sum / 2 + 1];
        dp[0][0] = true;
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i - 1]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[length][i]) {
                res = sum - 2 * i;
            }
        }
        return res;
    }
}
