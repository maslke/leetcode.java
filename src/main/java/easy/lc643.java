package easy;

/**
 * Author:maslke
 * Date:2017/10/2
 * Version:0.0.1
 * 643. Maximum Average Subarray I
 */
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
