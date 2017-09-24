package easy;

/**
 * Author:maslke
 * Date:2017/9/24
 * Version:0.0.1
 * 303. Range Sum Query - Immutable
 */
public class lc303 {
    int[] values;
    int[] v;
    public lc303(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        values = new int[length];
        v = nums;
        values[0] = nums[0];
        for (int i = 1; i < values.length; i++) {
            values[i] = values[i - 1] + nums[i];
        }
    }


    public int sumRange(int i, int j) {
        return values[j] - values[i] + v[i];
    }
}
