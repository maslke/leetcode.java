package hard;

// https://leetcode-cn.com/problems/reverse-pairs/
// 493. 翻转对

public class lc493 {
    private int reverse(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = (right + left) / 2;
        int n1 = reverse(nums, left, middle);
        int n2 = reverse(nums, middle + 1, right);

        int ret = 0;
        int i = left;
        int j = middle + 1;
        while (i <= middle) {
            while (j <= right && (long) nums[i] > (long)2 * nums[j]) {
                j++;
            }
            ret += j - middle - 1;
            i++;
        }

        merge(nums, left, right, middle);
        return n1 + n2 + ret;
    }



    private void merge(int[] nums, int left, int right, int middle) {
        int[] sorted = new int[right - left + 1];

        int i = left;
        int j = middle + 1;
        int p = 0;
        while (i <= middle || j <= right) {
            if (i <= middle && j <= right) {
                if (nums[i] < nums[j]) {
                    sorted[p++] = nums[i++];
                } else {
                    sorted[p++] = nums[j++];
                }
            } else if (i <= middle) {
                sorted[p++] = nums[i++];
            } else if (j <= right) {
                sorted[p++] = nums[j++];
            }
        }

        for (int m = 0; m < sorted.length; m++) {
            nums[left + m] = sorted[m];
        }

    }
}
