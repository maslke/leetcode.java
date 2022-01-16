package medium;

// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
// 215. 数组中的第K个最大元素
public class lc215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];


        int left = 0;
        int right = nums.length - 1;
        int size = nums.length - k;
        while (true) {
            int p = partition(nums, left, right);
            if (p == size) {
                return nums[p];
            } else if (p > size) {
                right = p - 1;
            } else {
                left = p + 1;
            }
        }

    }

    private int partition(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int v = nums[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (nums[++i] < v) {
                if (i == right) break;
            }
            while (nums[--j] > v) {
                if (j == left) break;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
