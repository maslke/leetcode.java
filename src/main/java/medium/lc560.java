package medium;

// https://leetcode-cn.com/problems/subarray-sum-equals-k/
// 560. 和为K的子数组

import java.util.HashMap;
import java.util.Map;

class lc560 {

    // 重点在于使用哈希表进行优化

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int acc = 0;
        map.put(0, 1);
        for (int num : nums) {
            acc += num;
            if (map.containsKey(acc - k)) {
                count += map.get(acc - k);
            }
            map.put(acc, map.getOrDefault(acc, 0) + 1);
        }
        return count;
    }
}