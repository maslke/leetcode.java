package medium;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//153. Find Minimum in Rotated Sorted Array

class lc153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
            else {
                right--;
            }
        }
        return nums[left];
    }
}