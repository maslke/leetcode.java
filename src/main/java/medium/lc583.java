package medium;

// https://leetcode-cn.com/problems/delete-operation-for-two-strings/
// 583. 两个字符串的删除操作
public class lc583 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1][l2];

        // dp[i][j] 为已i,j结尾的字符串，最长公共子串
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 1 : 0;

        for (int i = 1; i < l2; i++) {
            dp[0][i] = word1.charAt(0) == word2.charAt(i) || dp[0][i - 1] == 1 ? 1 : 0;
        }
        for (int i = 1; i < l1; i++) {
            dp[i][0] = word1.charAt(i) == word2.charAt(0) || dp[i - 1][0] == 1 ? 1 : 0;
        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return l1 + l2 - 2 * dp[l1 - 1][l2 - 1];
    }
}
