package easy;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc198 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] values = new int[nums.length];
        values[0] = nums[0];
        values[1] = Math.max(values[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            values[i] = Math.max(values[i - 2] + nums[i], values[i - 1]);
        }
        return values[nums.length - 1];
    }
}
