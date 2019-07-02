package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 136. Single Number
 * ????
 */
public class lc136 {

    public int singleNumber2(int[] nums) {
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            v = nums[i] ^ v;
        }
        return v;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            return key;
        }
        return -1;

    }
}
