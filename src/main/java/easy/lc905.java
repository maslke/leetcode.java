package easy;
/**
 * 905. Sort Array By Parity
 * easy
 */

 public class lc905 {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 == 0) {
                i++;
                continue;
            }
            if (A[j] % 2 == 1) {
                j--;
                continue;
            }
            if (i < j) {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                i++;
                j--;
            }
        }
        return A;
    }
 }