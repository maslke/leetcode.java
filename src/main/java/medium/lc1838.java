package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
// 1838. 最高频元素的频数

public class lc1838 {
    public int maxFrequency(int[] nums, int k) {
        int ret = 1;
        Arrays.sort(nums);
        int left = 0;
        long sum = 0;
        for (int right = 1; right < nums.length; right++) {
            // a[5] - a[4] + a[5] - a[3] + a[5] - a[2]
            // a[5] - a[4] + a[5] + a[4] - a[4] - a[3] + a[5] + a[4] - a[4] - a[2]
            // a[5] - a[4] + a[5] - a[4] + a[4] - a[3] + a[5] - a[4] + a[4] + a[3] - a[3] - a[2]
            // a[5] - a[4] + a[5] - a[4] + a[5] - a[4] + a[4] - a[3] + a[4] - a[3] + a[3] - a[2]
            // 3 * (a[5] - a[4]) + 2 * (a[4] - a[3]) + (a[3] - a[2])
            sum += (long) ((nums[right] - nums[right - 1]) * (right - left));
            while (sum > k) {
                sum -= nums[right] - nums[left];
                left++;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}
