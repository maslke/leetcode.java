package medium;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 34. Search for a Range
 */
public class lc34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        int i = 0, j = nums.length-1;
        boolean left = false, right = false;
        while(i <= j) {
            if (nums[i] < target) {
                i++;
            } else {
                left = true;
            }
            if (nums[j] > target) {
                j--;
            } else {
                right = true;
            }
            if (left && right) {
                break;
            }
        }
        if (i <= j) {
            ret[0] = i;
            ret[1] = j;
        } else {
            ret[0] = -1;
            ret[1] = -1;
        }
        return ret;
    }
}
