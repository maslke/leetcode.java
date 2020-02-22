package easy;

// https://leetcode-cn.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
// 1150. 检查一个数是否在数组中占绝大多数

class lc1150 {
    public boolean isMajorityElement(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                sum ++;
            } else {
                sum--;
            }
        }
        return sum > 0;
    }
}