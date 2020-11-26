package medium;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
// 1296. 划分数组为连续数字的集合

public class lc1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        int length = nums.length;
        if (length % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            int key = entry.getKey();
            int value = entry.getValue();
            for (int i = 1; i < k; i++) {
                int times = map.getOrDefault(key + i, 0);
                if (times < value) {
                    return false;
                }
                if (times - value != 0) {
                    map.replace(key + i, times - value);
                } else {
                    map.remove(key + i);
                }
            }
        }
        return true;
    }
}
