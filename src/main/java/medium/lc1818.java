package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
// 1818. 绝对差值和

public class lc1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] diff = new int[length];
        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);

        }
        Arrays.sort(nums1);
        int max = -1;
        for (int i = 0; i < length; i++) {
            int v = nums2[i];
            int low = 0;
            int high = length - 1;
            int target = 200001;
            while (low <= high) {
                int m = (high - low) / 2 + low;
                target = Math.min(target, Math.abs(nums1[m] - v));
                if (nums1[m] == v) {
                    break;
                }
                else if (nums1[m] < v) {
                    low = m + 1;
                }
                else {
                    high = m - 1;
                }
            }
            max = Math.max(max, diff[i] - target);
        }


        int f = 1000000007;
        int ret = 0;
        for (int j : diff) {
            ret = (ret + j) % f;
        }
        return (ret - max + f) % f;
    }
}
