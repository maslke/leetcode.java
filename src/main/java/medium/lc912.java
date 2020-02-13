package medium;

// https://leetcode.com/problems/sort-an-array/
// 912. Sort an Array

class lc912 {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            ret.add(nums[i]);
        }
        return ret;
    }

    private void sort(int[] values, int low, int high) {
        if (low >= high) return;
        int j = partition(values, low, high);
        sort(values, low, j - 1);
        sort(values, j + 1, high);
    }

    private boolean less(int a, int b) {
        return a < b;
    }

    private void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    private int partition(int[] values, int low, int high) {
        int m = values[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(values[++i], m)) {
                if (i == high) break;
            }
            while (less(m, values[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(values, i, j);
        }
        swap(values, low, j);
        return j;
    }
}