package easy;

/**
 * Author:maslke
 * Date:2017/8/29
 * Version:0.0.1
 * 485. Max Consecutive Ones
 */
public class lc485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, length = nums.length;
        int max = 0;
        while (i < length) {
            if (nums[i] == 1) {
                int k = i + 1;
                int len = 1;
                for (;k < length; k++) {
                    if (nums[k] != 1) {
                        break;
                    }
                    len++;
                }
                i = k + 1;
                if (max < len) {
                    max = len;
                }
            } else {
                i++;
            }
        }
        return max;
    }
}
