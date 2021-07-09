package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/binary-subarrays-with-sum/
// 930. 和相同的二元子数组

public class lc930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int length = nums.length;
        int[] acc = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            acc[i] = acc[i - 1] + nums[i - 1];
        }

        if (acc[length] < goal) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int a : acc) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int left = goal + key;
            if (left < 0) {
                continue;
            }
            if (key == left) {
                int val = entry.getValue();
                ret += val * (val - 1) / 2;
            }
            else {
                ret += map.getOrDefault(left, 0) * entry.getValue();
            }
        }

        return ret;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        int length = nums.length;
        int ret = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            ret += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return ret;
    }
}
