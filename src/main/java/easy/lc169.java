package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/18
 * Version:0.0.1
 * 169. Majority Element
 */
public class lc169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return 0;
    }


    // a much better solution
    public int majorityElement2(int[] nums) {
        int count = 0;
        int v = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                v = nums[i];
                count = 1;
            } else {
                if (v == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        if (count > 0) return v;
        return -1;
    }
}
