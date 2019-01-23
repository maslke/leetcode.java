//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//153. Find Minimum in Rotated Sorted Array
package medium;

class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);    
    }
    
    private int findMin(int[] nums, int start, int end) {
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i + 1] < nums[i]) {
                index = i + 1;
                break;
            } 
        }
        if (index + 1 >= end) {
            return nums[index];
        } else {
            int min = findMin(nums, index + 1, end);
            return Math.min(min, nums[index]);
        }
        
    }
}