package medium;

// https://leetcode-cn.com/problems/jump-game-ii/
// 45. 跳跃游戏

import java.util.Arrays;

public class lc45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < length; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[length - 1];
    }
}
