package hard;

import java.util.Arrays;

// https://leetcode-cn.com/problems/strange-printer/
// 664. 奇怪的打印机

public class lc664 {
    public int strangePrinter(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 1;
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                }
                else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][length - 1];
    }
}
