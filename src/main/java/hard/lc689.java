package hard;

//https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
// 689. 三个无重叠子数组的最大和
public class lc689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int maxSum1 = 0, maxSum12 = 0, maxSum123 = 0;
        int maxSum1Index = 0, maxSum12Index1 = 0, maxSum12Index2 = 0;
        int[] ret = new int[3];
        for (int i = 2 * k; i < nums.length; i++) {
            sum1 += nums[i - 2 * k];
            sum2 += nums[i - k];
            sum3 += nums[i];

            if (i >= 3 * k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Index = i - 3 * k + 1;
                }
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    maxSum12Index1 = maxSum1Index;
                    maxSum12Index2 = i - 2 * k + 1;
                }

                if (maxSum12 + sum3 > maxSum123) {
                    maxSum123 = maxSum12 + sum3;
                    ret[0] = maxSum12Index1;
                    ret[1] = maxSum12Index2;
                    ret[2] = i - k + 1;
                }

                sum1 -= nums[i - 3 * k + 1];
                sum2 -= nums[i - 2 * k + 1];
                sum3 -= nums[i - k + 1];
            }
        }

        return ret;
    }
}
