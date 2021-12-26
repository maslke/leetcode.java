package medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/partition-equal-subset-sum/
// 416. 分割等和子集
public class lc416 {
    // 我是废物版解法
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            Set<Integer> set2 = new HashSet<>(set);
            for (int v : set) {
                if (v == half) return true;
                if (v + n <= half) {
                    set2.add(v + n);
                }
            }
            set2.add(n);
            set = set2;
        }
        return set.contains(half);
    }

    // dp solution
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        int max = -1;
        for (int n : nums) {
            sum += n;
            max = Math.max(n, max);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        if (max > half) {
            return false;
        }
        int len = nums.length;
        boolean[][] dp = new boolean[len][half + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < half + 1; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][half];
    }
}
