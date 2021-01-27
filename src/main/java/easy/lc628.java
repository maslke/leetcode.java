package easy;

// https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
// 628. 三个数的最大乘积

import java.util.Arrays;

public class lc628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);


    }
}
