package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/combination-sum-iv/
// 377. 组合总数 IV

public class lc377 {

    public int combinationSum4_2(int[] nums, int target) {
        // dp[i] = dp[i - nums[i]]
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] == 0) {
                    count += 1;
                }
                if (i - nums[j] > 0) {
                    count += dp[i - nums[j]];
                }
                dp[i] = count;
            }

        }
        return dp[target];
    }


    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        combine(nums, target, map);
        return map.getOrDefault(target, 0);
    }

    private int combine(int[] nums, int target, Map<Integer, Integer> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                continue;
            }

            if (target == nums[i]) {
                count += 1;
            }
            if (target > nums[i]) {
                count += combine(nums, target - nums[i], map);
            }
            map.put(target, count);
        }

        return map.getOrDefault(target, 0);
    }
}
