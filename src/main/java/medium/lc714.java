package medium;

// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// 714. 股票的最佳时机含手续费

public class lc714 {
    public int maxProfit(int[] prices, int fee) {
        int yes = -1 * prices[0];
        int no = 0;
        for (int i = 1; i < prices.length; i++) {
            int no2 = Math.max(no, prices[i] + yes - fee);
            yes = Math.max(no - prices[i], yes);
            no = no2;
        }
        return no;
    }
}
