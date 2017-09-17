package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/9/17
 * Version:0.0.1
 * 442. Find All Duplicates in an Array
 */
public class lc442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int m = Math.abs(nums[i]) - 1;
            if (nums[m] < 0) {
                ret.add(Math.abs(nums[i]));
            } else {
                nums[m] = -nums[m];
            }
        }
        return ret;
    }
}
