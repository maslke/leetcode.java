package easy;

/**
 * Author:maslke
 * Date:2017/8/30
 * Version:0.0.1
 */
public class lc283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != 0) {
                i++;
            } else {
                int k = i + 1;
                for (; k<= j; k++) {
                    nums[k - 1] = nums[k];
                }
                nums[j] = 0;
                j--;
            }
        }
    }
}
