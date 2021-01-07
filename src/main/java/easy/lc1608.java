package easy;

import java.util.Arrays;

// https://leetcode-cn.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
// 1608. 特征数组的特征值

public class lc1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int before = nums.length - 1;
        for (int i = n; i >= 0; i--) {
            int j = before;
            while (j >= 0 && nums[j] >= i) {
                j--;
            }
            count += before - j;
            if (count == i) {
                return i;
            }
            before = j;
        }
        return -1;
    }
}
