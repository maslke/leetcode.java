package medium;

//https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// 34. 在排序数组中查找元素的第一个和最后一个位置

class lc34 {
    // 想写对二分查找真的很难。
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int inx = findFirstGreater(nums, target);
        int inx2 = findLastSmaller(nums, target);

        //
        if (inx == -1 && nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }
        if (inx2 == -1 && nums[0] > target) {
            return new int[]{-1, -1};
        }

        if (inx == -1) {
            inx = nums.length;
        }

        if (inx - inx2 <= 1) return new int[]{-1, -1};

        return new int[]{inx2 + 1, inx - 1};
    }

    private int findFirstGreater(int[] nums, int target) {
        int ret = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = (right - left) / 2 + left;
            if (nums[m] > target) {
                ret = right;
                right = m - 1;
            }
            else {
                left = m + 1;
            }
        }
        return ret;
    }

    private int findLastSmaller(int[] nums, int target) {
        int ret = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = (right - left) / 2 + left;
            if (nums[m] < target) {
                ret = m;
                left = m + 1;
            }
            else {
                right = m - 1;
            }
        }
        return ret;

    }
}
