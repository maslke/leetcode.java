package medium;

// https://leetcode-cn.com/problems/max-number-of-k-sum-pairs/
// 1679. K和数对的最大数目

import java.util.Arrays;

public class lc1679 {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                count++;
                j--;
                i++;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }
}
