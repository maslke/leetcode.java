/**
 * Author:maslke
 * Date:2017/9/24
 * Version:0.0.1
 * 122. Best Time to Buy and Sell Stock II
 */
public class lc122 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0 || length == 1) {
            return 0;
        }
        int[] values = new int[length];
        values[0] = 0;
        int max = Integer.MIN_VALUE;
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            values[i] = Math.max(values[i - 1], values[i - 1] + prices[i] - prices[i - 1]);
            values[i] = Math.max(values[i], prices[i] - min);
            if (min > prices[i]) {
                min = prices[i];
            }
            if (max < values[i]) {
                max = values[i];
            }
        }
        return max;
    }
}
