package hard;

// https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
//  剑指 Offer 51. 数组中的逆序对

public class Offer51 {
    public int reversePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        return reverse(nums, 0, nums.length - 1);
    }

    private int reverse(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int middle = (right - left) / 2 + left;

        int n1 = reverse(nums, left, middle);
        int n2 = reverse(nums, middle + 1, right);

        if (nums[middle] <= nums[middle + 1]) {
            return n1 + n2;
        }

        int m = left;
        int n = middle + 1;
        int count = 0;
        while (m <= middle) {
            while (n <= right && nums[m] > nums[n]) {
                n++;
            }
            count += (n - middle - 1);
            m++;
        }

        int[] sorted = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int p = 0;
        while (i <= middle || j <= right) {
            if (i > middle) {
                sorted[p++] = nums[j++];
            } else if (j > right) {
                sorted[p++] = nums[i++];
            } else {
                if (nums[i] < nums[j]) {
                    sorted[p++] = nums[i++];
                } else {
                    sorted[p++] = nums[j++];
                }
            }
        }


        for (int index = 0; index < sorted.length; index++) {
            nums[left + index] = sorted[index];
        }
        return count + n1 + n2;
    }
}
