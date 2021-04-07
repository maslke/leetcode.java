package easy;

// https://leetcode-cn.com/problems/merge-sorted-array/
// 88. 合并两个有序数组

public class lc88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            }
            else {
                System.arraycopy(nums1, i, nums1, i + 1, m - i);
                nums1[i] = nums2[j];
                j++;
                m++;
                i++;
            }
        }
        while (j < n) {
            nums1[m++] = nums2[j++];
        }
    }
}
