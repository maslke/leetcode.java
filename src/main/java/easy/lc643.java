package easy;


// https://leetcode-cn.com/problems/maximum-average-subarray-i/
// 643. 子数组最大平均数 I

public class lc643 {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        double v = max;
        for (int i = k; i < nums.length; i++) {
            v = v + nums[i] - nums[i - k];
            if (v > max) {
                max = v;
            }
        }
        return max / k;
    }
}
