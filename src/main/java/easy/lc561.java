package easy;

import java.util.Arrays;

/**
 * Author:maslke
 * Date:2017/9/2
 * Version:0.0.1
 */
public class lc561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
