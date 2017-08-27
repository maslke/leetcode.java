package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 26. Remove Duplicates from Sorted Array
 */
public class lc26 {
    public int removeDuplicates(int[] nums) {
        int j = nums.length - 1;
        for (int i = 1; i <= j; i++) {
            if (nums[i] == nums[i - 1]) {
                for (int m = i; m < j; m++) {
                    nums[m] = nums[m + 1];
                }
                i--;
                j--;
            }
        }
        return j + 1;
    }
}
