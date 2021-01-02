package hard;

import java.util.Arrays;

// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
// 188. 买卖股票的最佳时机 IV
public class lc188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        int n = prices.length;
        // n / 2 最多能够执行的交易数
        k = Math.min(k, n / 2);

        int[][][] values = new int[2][n][k + 1];

        values[0][0][0] = -prices[0];

        for (int i = 1; i <= k; i++) {
            values[0][0][i] = values[1][0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; i++) {
            values[0][i][0] = Math.max(values[0][i - 1][0], values[1][i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                values[0][i][j] = Math.max(values[0][i - 1][j], values[1][i - 1][j] - prices[i]);
                values[1][i][j] = Math.max(values[1][i - 1][j], values[0][i - 1][j - 1] + prices[i]);
            }

        }

        return Arrays.stream(values[1][n - 1]).max().getAsInt();
    }
}
