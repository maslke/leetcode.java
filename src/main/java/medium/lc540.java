package medium;

/**
 * Author:maslke
 * Date:2017/8/30
 * Version:0.0.1
 * 540. Single Element in a Sorted Array
 */
public class lc540 {
    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length;
        if (j == 1) {
            return nums[0];
        }
        while (i < j) {
            int a = nums[i];
            if (i + 1 < j) {
                int b = nums[i + 1];
                if (a != b) {
                    return a;
                }
            } else {
                return a;
            }
            i = i + 2;
        }
        return nums[j - 1];
    }
}
