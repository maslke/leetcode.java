package easy;

// https://leetcode-cn.com/problems/max-consecutive-ones/
// 485. 最大连续1的个数

public class lc485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 0;
        int len = nums.length;
        while (right < len) {
            if (nums[right] == 0) {
                max = Math.max(max, right - left);
                left = right + 1;
                right = left;
            } else {
                right++;
            }
        }

        return Math.max(max, right - left);
    }
}
