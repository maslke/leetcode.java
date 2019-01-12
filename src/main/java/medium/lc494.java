//https://leetcode.com/problems/target-sum/
//494. Target Sum
package medium;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTarget(nums, 0, nums.length - 1, S);        
    }
    
    private int findTarget(int[] nums, int begin, int end, int S) {
        if (begin == end) {
            if (nums[begin] == S || nums[begin] == -S) {
                if (S == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
            return 0;
        }  else {
            return findTarget(nums, begin + 1, end, S + nums[begin]) + findTarget(nums, begin + 1, end, S - nums[begin]);
        }
    }
}