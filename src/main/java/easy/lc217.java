package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/29
 * Version:0.0.1
 * 217. Contains Duplicate
 */
public class lc217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}
