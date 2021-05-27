package medium;

// https://leetcode-cn.com/problems/uncrossed-lines/
// 1035. 不相交的线

public class lc1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1][len2];

        dp[0][0] = nums1[0] == nums2[0] ? 1 : 0;
        for (int i = 1; i < len2; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
            }
            else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < len1; i++) {
            if (nums2[0] == nums1[i]) {
                dp[i][0] = 1;
            }
            else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
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
