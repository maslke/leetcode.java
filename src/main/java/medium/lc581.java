package medium;

// https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
// 581. 最短无序连续子数组

import java.util.Arrays;

public class lc581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);

        Arrays.sort(copy);

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (copy[i] == nums[i]) {
                i++;
            }
            else {
                break;
            }
        }
        if (i == j + 1) {
            return 0;
        }
        while (j >= 0) {
            if (copy[j] == nums[j]) {
                j--;
            }
            else {
                break;
            }
        }
        return j - i + 1;
    }
}
