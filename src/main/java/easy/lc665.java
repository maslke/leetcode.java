package easy;

// https://leetcode-cn.com/problems/non-decreasing-array/
// 665. 非递减数列

public class lc665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
                else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return true;
    }
}
