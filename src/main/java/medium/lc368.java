package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/largest-divisible-subset/
// 368. 最大整除子集
// CV

public class lc368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        int maxValue = nums[0];
        int maxSize = 1;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (maxSize < dp[i]) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }

        if (maxSize == 1) {
            return Collections.singletonList(nums[0]);
        }

        LinkedList<Integer> result = new LinkedList<>();
        for (int i = length - 1; i >= 0 && maxSize > 0; i--) {
            if (maxSize == dp[i] && maxValue % nums[i] == 0) {
                maxValue = nums[i];
                maxSize--;
                result.offerFirst(maxValue);
            }
        }
        return result;
    }
}
