package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
// 1877. 数组中最大数对和的最小值
public class lc1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int ret = 0;
        while (i < j) {
            ret = Math.max(ret, nums[i] + nums[j]);
            i++;
            j--;
        }
        return ret;
    }
}
