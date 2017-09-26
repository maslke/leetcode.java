package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/26
 * Version:0.0.1
 * 532. K-diff Pairs in an Array
 */
public class lc532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 1 + map.get(nums[i]));
            } else {
                map.put(nums[i], 1);
            }
        }
        int count = 0;
        if (k != 0) {
            for (Integer key1 : map.keySet()) {
                if (map.containsKey(key1 - k)) {
                    count++;
                }
                if (map.containsKey(key1 + k)) {
                    count++;
                }
            }
            return count  / 2;
        } else {
            for (Integer key1: map.keySet()) {
                if (map.get(key1) > 1) {
                    count += 1;
                }
            }
            return count;
        }
    }
}
