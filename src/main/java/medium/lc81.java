package medium;

// https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
// 81. 搜索旋转排序数组II

class lc81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int v = nums[mid];
            if (v == target || nums[left] == target || nums[right] == target) return true;
            if (v < nums[right]) {
                if (v < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (v > nums[left]) {
                if (nums[left] < target && target < v) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}