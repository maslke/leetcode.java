package easy;

// https://leetcode-cn.com/problems/rotate-array/
// 189. 旋转数组

public class lc189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        revert(nums, 0, len - k - 1);
        revert(nums, len - k, len - 1);
        revert(nums, 0, len - 1);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void revert(int[] a, int begin, int end) {
        int i = begin;
        int j = end;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
}
