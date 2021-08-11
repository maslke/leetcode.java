package hard;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/
// 446. 等差数列划分 II - 子序列
public class lc446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int ret = 0;
        int n = nums.length;
        Map<Long, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<Long, Integer>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                int v = dp[j].getOrDefault(d, 0);
                ret += v;
                dp[i].put(d, v + 1 + dp[i].getOrDefault(d, 0));
            }
        }

        return ret;
    }
}
