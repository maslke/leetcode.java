package easy;

//https://leetcode.com/problems/maximum-subarray/
//53. Maximum Subarray
//@date:2019/01/07
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            } else {
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }
}