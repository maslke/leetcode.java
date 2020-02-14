package medium;

import java.util.Arrays;

// https://leetcode.com/problems/valid-triangle-number/
// 611. Valid Triangle Number
class lc611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}