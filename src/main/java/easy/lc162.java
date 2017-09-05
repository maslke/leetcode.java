package easy;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 162. Find Peak Element
 * IMPORTANT
 * 思路要学习一下
 */
public class lc162 {
    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        } else if (left + 1 == right) {
            if (nums[left] < nums[right]) {
                return right;
            } else {
                return left;
            }
        } else {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return find(nums, left, mid - 1);
            } else {
                return find(nums, mid + 1, right);
            }
        }
    }
}
