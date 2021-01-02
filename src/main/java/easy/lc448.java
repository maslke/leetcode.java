package easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
// 448. 找到所有数组中消失的数字

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
