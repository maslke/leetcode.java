package easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// 122. Best Time to Buy and Sell Stock II


class lc122 {
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
