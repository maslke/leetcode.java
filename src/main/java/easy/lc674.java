
package easy;

// https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
// 674. 最长连续递增序列

public class lc674 {
    public int findLengthOfLCIS(int[] nums) {
        int ret = 1;
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int i = 0;
        while (i < len) {
            int j = i + 1;
            while (j < len && nums[j] > nums[j - 1]) {
                j++;
            }

            ret = Math.max(ret, j - i);
            i = j;
        }
        return ret;
    }
}
