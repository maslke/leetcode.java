package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/continuous-subarray-sum/
// 523. 连续的子数组和
public class lc523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int acc = 0;
        for (int i = 0; i < nums.length; i++) {
            acc += nums[i];
            int p = acc % k;
            if (map.containsKey(p)) {
                int inx = map.get(p);
                if (i - inx >= 2) {
                    return true;
                }
            }
            else {
                map.put(p, i);
            }
        }
        return false;
    }
}
