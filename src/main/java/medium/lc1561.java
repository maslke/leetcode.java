package medium;

// https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get/
// 1561. 你可以获得的最大硬币数目

import java.util.Arrays;

public class lc1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int length = piles.length;
        int num = 0;
        for (int i = length / 3; i < length; i = i + 2) {
            num += piles[i];
        }
        return num;
    }
}
