package easy;

// https://leetcode-cn.com/problems/summary-ranges/
// 228. 汇总区间

import java.util.ArrayList;
import java.util.List;

public class lc228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int j = i;
            while (j < len - 1 && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            StringBuilder sb = new StringBuilder();
            if (j == i) {
                sb.append(nums[i]);

            } else {
                sb.append(nums[i]).append("->").append(nums[j]);

            }
            ret.add(sb.toString());
            i = j + 1;
        }
        return ret;
    }
}
