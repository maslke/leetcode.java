package easy;

// https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/
// 1413. 逐步求和得到整数的最小值

public class lc1413 {
    public int minStartValue(int[] nums) {
        int prev = nums[0];
        int min = prev;
        for (int i = 1; i < nums.length; i++) {
            prev += nums[i];
            if (prev < min) {
                min = prev;
            }
        }
        if (min > 0) {
            return 1;
        } else {
            return 1 - min;
        }
    }
}
