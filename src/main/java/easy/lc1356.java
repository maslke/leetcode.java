package easy;

class lc1356 {
    public int[] sortByBits(int[] arr) {
        sort(arr, 0, arr.length - 1);    
        return arr;
    }
    
    private void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int p = partition(arr, low, high);
        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp  =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private boolean less(int a, int b) {
        int v1 = Integer.bitCount(a);
        int v2 = Integer.bitCount(b);
        if (v1 < v2) {
            return true;
        } else if (v1 == v2) {
            return a < b;
         } else {
            return false;
        }
    }
    
    private int partition(int[] arr, int low, int high) {
        int m = arr[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], m)) {
                if (i == high) break;
            }
            while (less(m, arr[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }
}