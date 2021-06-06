package medium;

// https://leetcode-cn.com/problems/ones-and-zeroes/
// 474. 一和零

public class lc474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];


        for (int i = 1; i <= length; i++) {
            int[] res = count(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {

                    if (res[0] <= j && res[1] <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - res[0]][k - res[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }

                }
            }
        }
        return dp[length][m][n];
    }

    private int[] count(String str) {
        int length = str.length();
        int[] res = new int[2];
        for (int i = 0; i < length; i++) {
            if (str.charAt(i)  == '0') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }
}
