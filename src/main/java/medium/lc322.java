package medium;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
// 322. Coin Change

class lc322 {
    public int coinChange(int[] coins, int amount) {
        int[] ret = new int[amount + 1];
        Arrays.fill(ret, amount + 1);
        ret[0] = 0;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    ret[j] = Math.min(ret[j], ret[j - coin] + 1);
                }
            }
        }
        return ret[amount] > amount ? -1 : ret[amount];
    }
}