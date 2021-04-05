package easy;

// https://leetcode-cn.com/problems/longest-common-subsequence/
// 1143. 最长公共子序列

public class lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1][len2];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < len2; i++) {
            if (text1.charAt(0) == text2.charAt(i)) {
                dp[0][i] = 1;
            }
            else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < len1; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            }
            else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1 - 1][len2 - 1];
    }
}
