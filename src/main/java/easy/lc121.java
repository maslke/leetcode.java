package easy;

/**
 * Author:maslke
 * Date:2017/9/24
 * Version:0.0.1
 * 121. Best Time to Buy and Sell Stock
 */
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
public class lc121 {


    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int benefit = 0;
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            benefit = Math.max(benefit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return benefit;
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 0;
        }
        int[] values = new int[length];
        values[0] = prices[0];
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            values[i] = Math.max(values[i], prices[i] - min);
            if (max < values[i]) {
                max = values[i];
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return max;
    }

}
