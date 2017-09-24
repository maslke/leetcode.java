package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/24
 * Version:0.0.1
 * 506. Relative Ranks
 */
public class lc506 {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int length = nums.length;
        String[] ret = new String[length];
        for (int i = 0; i < nums.length; i++) {
            int inx = map.get(nums[i]);
            if (i == length - 1) {
                ret[inx] = "Gold Medal";
            } else if (i == length - 2) {
                ret[inx] = "Silver Medal";
            } else if (i == length - 3) {
                ret[inx] = "Bronze Medal";
            } else {
                ret[inx] = (length - i) + "";
            }
        }
        return ret;
    }
}
