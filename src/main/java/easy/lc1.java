package easy;
import java.util.Map;
import java.util.HashMap;
/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 1. Two Sum
 */
public class lc1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ret[0] = map.get(target - nums[i]);
                ret[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return ret;
    }
}
