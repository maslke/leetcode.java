package easy;

/**
 * lc.922 Sort Array By Parity II
 * easy
 */
class lc922 {
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private boolean valid(int a, int b) {
        return a % 2 == b % 2;
    }

    public int[] sortArrayByParityII2(int[] A) {

        for (int i = 0; i < A.length; i = i + 2) {
            if (!valid(A[i], i)) {
                int j = i + 1;
                while (valid(A[j], j)) {
                    j = j + 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < A.length) {
            if (valid(A[i], i)) {
                i++;
            } else {
                int k = j;
                while (k > i) {
                    if (!valid(A[k], k) && !valid(i, k)) {
                        swap(A, i, k);
                        break;
                    } else {
                        k--;
                    }
                }
            }
        }
        return A;
    }
}