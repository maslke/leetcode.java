package medium;

// https://leetcode-cn.com/problems/smallest-k-lcci/
// 面试题 17.14. 最小K个数
public class lc17_14 {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] ret = new int[k];
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (true) {

            int p = partition(arr, left, right);
            if (p == k - 1) {
                System.arraycopy(arr, 0, ret, 0, k);
                break;
            }
            else if (p > k - 1) {
                right = p - 1;
            }
            else {
                left = p + 1;
            }
        }

        return ret;
    }

    private int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right + 1;
        int m = arr[left];
        while (true) {
            while (less(arr[++i], m)) {
                if (i == right) {
                    break;
                }
            }

            while (less(m, arr[--j])) {
                if (j == left) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
        }
        swap(arr, left, j);
        return j;
    }

    private boolean less(int a, int b) {
        return a < b;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
