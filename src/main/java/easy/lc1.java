package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 1. Two Sum
 */
public class lc1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> values = map.get(nums[i]);
                values.add(i);
                map.put(nums[i], values);
            } else {
                List<Integer> values = new ArrayList<Integer>();
                values.add(i);
                map.put(nums[i], values);
            }
        }
        for (Integer key : map.keySet()) {
            List<Integer> values = map.get(key);
            int left = target - key;
            if (key == left) {
                if (values.size() > 1) {
                    ret[0] = values.get(0);
                    ret[1] = values.get(1);
                }
            } else {
                if (map.containsKey(left)) {
                    List<Integer> values1 = map.get(left);
                    if (values.get(0) > values1.get(0)) {
                        ret[0] = values1.get(0);
                        ret[1] = values.get(0);
                    } else {
                        ret[0] = values.get(0);
                        ret[1] = values1.get(0);
                    }
                }
            }
        }
        return ret;
    }
}
