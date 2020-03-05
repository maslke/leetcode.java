package medium;

// https://leetcode.com/problems/product-of-array-except-self/
// 238. Product of Array Except Self

class lc238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = len - 2; i>= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        } 
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = left[i] * right[i];
        }
        return ret;
    }
}