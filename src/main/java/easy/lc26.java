package easy;

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

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int v = nums[i];
            int m = i;
            int count = 0;
            while (m < j) {
                if (nums[m] == v) {
                    count++;
                    m++;
                } else {
                    break;
                }
            }
            if (count > 1) {
                for (int k = m; k < j; k++) {
                nums[k - (count - 1)] = nums[k];
                }
            } 
            i = i + 1;
            j = j - (count - 1);
        }
        return j;
    }
}
