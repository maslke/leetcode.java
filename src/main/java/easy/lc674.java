package easy;

/**
 * Author:maslke
 * Date:2017/9/12
 * Version:0.0.1
 * 674. Longest Continuous Increasing Subsequence
 */
public class lc674 {
    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0;
        int length = nums.length;
        int i = 0;
        while (i < length) {
            int j = i + 1;
            int len = 1;
            for (; j < length; j++) {
                if (nums[j] > nums[j - 1]) {
                    len++;
                } else {
                    break;
                }
            }
            if (len > maxLength) {
                maxLength = len;
            }
            i = j;
        }
        return maxLength;
    }
}
