package easy;

/**
 * Author:maslke
 * Date:2017/9/11
 * Version:0.0.1
 * 88. Merge Sorted Array
 */
public class lc88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = 0, j = 0;
        int mm = m;
        while (i < mm && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                for (int k = m + j; k >= i + 1; k--) {
                    nums1[k] = nums1[k - 1];
                }
                nums1[i] = nums2[j];
                j++;
                i++;
                mm++;
            }
        }
        while(j < n) {
            nums1[m + j] = nums2[j];
            j++;
        }
    }
}
