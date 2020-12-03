package easy;

// https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
// 1464. 数组中两元素的最大乘积

public class lc1464 {
    // nums[i] >= 1
    public int maxProduct(int[] nums) {
        int a = Math.max(nums[0], nums[1]);
        int b = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= a) {
                b = a;
                a = nums[i];
            } else if (nums[i] >= b) {
                b = nums[i];
            }
        }

        return (a - 1) * (b - 1);
    }
}
