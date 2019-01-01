/**
 * lc.922 Sort Array By Parity II
 * easy
 */
class Solution {
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < A.length) {
            if ((A[i] % 2 + i % 2 ) % 2 == 0) {
                i++;
            } else {
                int k = j;
                while (k > i) {
                    if ((A[k] % 2 + k % 2) % 2 == 1 && (A[i] % 2 + A[k] % 2) % 2 == 1) {
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