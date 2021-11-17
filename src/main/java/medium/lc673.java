package medium;

// https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
// 673. 最长递增子序列的个数

public class lc673 {



    public int findNumberOfLIS2(int[] nums) {

        int ret = 0;
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int max = 0;


        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }


            if (dp[i] > max ) {
                max = dp[i];
                ret = cnt[i];
            } else if (dp[i] == max) {
                ret += cnt[i];
            }
        }

        return ret;
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0]);
                }
            }

            dp[i][0]++;

            for (int j = 0; j < i; j++) {
                if (dp[j][0] == dp[i][0] - 1 && nums[j] < nums[i]) {
                    dp[i][1] += dp[j][1];
                }
            }
            if (dp[i][0] == 1) {
                dp[i][1] = 1;
            }
        }
        int ret = 1;
        int max = 0;
        for (int[] ints : dp) {
            if (ints[0] > max) {
                max = ints[0];
                ret = ints[1];
            }
            else if (ints[0] == max) {
                ret += ints[1];
            }
        }
        return ret;
    }
}
