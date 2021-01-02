package medium;

// https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
// 659. 分割数组为连续子序列

import java.util.HashMap;
import java.util.Map;

public class lc659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (map.get(v) > 0) {
                if (map2.getOrDefault(v - 1, 0) > 0) {
                    map2.put(v - 1, map2.get(v - 1) - 1);
                    map2.put(v, map2.getOrDefault(v, 0) + 1);
                    map.put(v, map.get(v) - 1);
                } else {
                    if (map.getOrDefault(v + 1, 0) == 0 || map.getOrDefault(v + 2, 0) == 0) {
                        return false;
                    }
                    map2.put(v + 2, map2.getOrDefault(v + 2, 0) + 1);
                    map.put(v, map.get(v) - 1);
                    map.put(v + 1, map.get(v + 1) - 1);
                    map.put(v + 2, map.get(v + 2) - 1);
                }
            }

        }
        return true;
    }
}
