package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/
// 525. Contiguous Array

class lc525 {
    public int findMaxLength(int[] nums) {
        if (nums.length < 2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // important
            if (sum == 0 && i > max) {
                max = i + 1;
            }
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max;
    }
}