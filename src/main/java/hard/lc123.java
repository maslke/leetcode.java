package hard;

// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
// 123. 买卖股票的最佳时机 III

public class lc123 {
    public int maxProfit(int[] prices) {
        int buy0 = 0;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, buy0 - prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
