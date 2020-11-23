package easy;

// https://leetcode-cn.com/problems/summary-ranges/
// 228. 汇总区间

import java.util.ArrayList;
import java.util.List;

public class lc228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }
            if (j == i + 1) {
                ret.add(nums[i] + "");
            } else {
                ret.add(nums[i] + "->" + nums[j - 1]);
            }

            i = j;
        }

        return ret;
    }
}
