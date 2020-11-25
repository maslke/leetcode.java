package easy;

public class lc1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 1) {
            return false;
        }
        if (arr.length == 2) {
            return true;
        }
        sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }

    private void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int m = arr[left];
        int i = left;
        int j = right + 1;
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

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
