package medium;

// https://leetcode-cn.com/problems/minimum-size-subarray-sum/
// 209. 长度最小的子数组

public class lc209 {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;
        int res = len + 1;
        while (right < len) {
            sum += nums[right];
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
                sum -= nums[right];
                right--;
            }
            right++;
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
