package easy;

class lc1089 {
    public void duplicateZeros(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] == 0) {
                for (int m = j - 1; m >= i; m--) {
                    arr[m + 1] = arr[m];
                }
                arr[i + 1] = 0;
                i = i + 2;
            } else {
                i++;
            }
        }
    }
}