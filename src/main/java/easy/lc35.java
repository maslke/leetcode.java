

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 35. Search Insert Position
 */
public class lc35 {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        if (i == nums.length) {
            return nums.length;
        }
        return 0;
    }
}
