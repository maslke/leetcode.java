package medium;

// https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
// 81. 搜索旋转排序数组II

class lc81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (nums[middle] == target || nums[left] == target || nums[right] == target) {
                return true;
            }
            if (target > nums[left] && target < nums[middle]) {
                right = middle - 1;
            } else if (target < nums[right] && target > nums[middle]) {
                left = middle + 1;
            } else {
                left++;
                right--;
            }
        }
        return false;
    }
}