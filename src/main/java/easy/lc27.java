

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 27. Remove Element
 */
public class lc27 {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        for (i = 0; i <= j; i++) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
                i--;
            }
        }
        return j + 1;
    }
}
