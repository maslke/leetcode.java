package medium;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// 34. Find First and Last Position of Element in Sorted Array

class lc34 {
    private int a;
    private int b;
    public int[] searchRange(int[] nums, int target) {
        a = -1;
        b = -1;
        search(nums, 0, nums.length - 1, target);
        return new int[]{a, b};
    }

    private void search(int[] nums, int low, int high, int target) {
        if (low > high) return;
        int middle = low + (high - low) / 2;
        int v = nums[middle];
        if (v == target) {
            if (a == -1 || a > middle) {
                a = middle;
            }
            if (b == -1 || b < middle) {
                b = middle;
            }

            search(nums, low, middle - 1, target);
            search(nums, middle + 1, high, target);
        } else if (v < target) {
            search(nums, middle + 1, high, target);
        } else {
            search(nums, low, middle - 1, target);
        }
    }
}
