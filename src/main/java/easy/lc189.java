package easy;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 189. Rotate Array
 */
public class lc189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        for (int i = 0; i < k; i++) {
            int temp = nums[length - 1];
            for (int j = length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }
}
