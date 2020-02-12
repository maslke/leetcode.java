package easy;

// https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
// 面试题40. 最小的k个数

class lcof40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        if (k == arr.length) return arr;
        int low = 0;
        int high = arr.length - 1;
        int[] ret = new int[k];
        while (true) {
            int p = partition(arr, low, high);
            if (p == k - 1) {
                for (int i = 0; i < k; i++) {
                    ret[i] = arr[i];
                }
                break;
            } else if (p > k - 1) {
                high = p - 1;
            } else {
                low = p + 1;
            }
        }
        return ret;
    }

    private void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    private boolean less(int a, int b) {
        return a < b;
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