package hard;

/**
 * Author:maslke
 * Date:2017/9/2
 * Version:0.0.1
 * 4. Median of Two Sorted Arrays
 */
public class lc4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double[] ret = new double[len1 + len2];
        int i = 0, j = 0;
        int inx = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                ret[inx] = nums1[i];
                i++;
            } else {
                ret[inx] = nums2[j];
                j++;
            }
            inx++;
        }
        if (i == len1) {
            for (int k = j; k < len2; k++) {
                ret[inx++] = nums2[k];
            }
        } else {
            for (int k = i; k < len1; k++) {
                ret[inx++] = nums1[k];
            }
        }

        int total = len1 + len2;
        if (total == 1) {
            return ret[0];
        }
        if (total % 2 == 1) {
            return ret[(int)(total / 2)];
        } else {
            return (ret[total / 2] + ret[total / 2 -1]) / 2;
        }

    }
}
