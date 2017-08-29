package easy;

/**
 * Author:maslke
 * Date:2017/8/29
 * Version:0.0.1
 * 268. Missing Number
 */
public class lc268 {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int max = 0;

        int sum2 = 0;
        for (int i = 0; i < length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            sum2 += nums[i];
        }
        if (max == length) {
            int sum = (length + 1) * (0 + length) / 2;
            return sum - sum2;
        } else {
            return length;
        }

    }
}
