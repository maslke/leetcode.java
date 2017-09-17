package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/9/17
 * Version:0.0.1
 * 448. Find All Numbers Disappeared in an Array
 */
public class lc448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int m = Math.abs(nums[i]) - 1;
            if (nums[m] > 0) {
                nums[m] = - nums[m];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
