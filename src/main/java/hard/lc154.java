package hard;

// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
// 154. 寻找旋转排序数组中的最小值 II

public class lc154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (right - left) / 2 + left;
            int compare = Integer.compare(nums[middle], nums[right]);
            if (compare < 0) {
                right = middle;
            }
            else if (compare == 0) {
                right--;
            }
            else {
                left = middle + 1;
            }
        }
        return nums[left];
    }
}
