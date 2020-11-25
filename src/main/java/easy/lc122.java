package easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
// 122. Best Time to Buy and Sell Stock II

class lc122 {

    public int maxProfit2(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        // 0 不持有股票
        // 1 持有股票
        dp[0] = new int[] {0, - 1 * prices[0]};

        for (int i = 1; i < length; i++) {
            dp[i] = new int[] {0, 0};
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }

    public int maxProfit(int[] prices) {
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ret += prices[i] - prices[i - 1];
            }
        }
        return ret;
    }
}
