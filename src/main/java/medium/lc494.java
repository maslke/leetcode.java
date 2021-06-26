
package medium;

//https://leetcode.com/problems/target-sum/
//494. Target Sum
// https://leetcode-cn.com/problems/target-sum/
// 494.目标和
class lc494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 == 1) {
            return 0;
        }
        int neg = diff / 2;
        int length = nums.length;
        int[][] dp = new int[length + 1][neg + 1];
        dp[0][0] = 1;
        // dp[i][j] 数组中前i个数，和为j的方案数
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= neg; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][neg];
    }
}