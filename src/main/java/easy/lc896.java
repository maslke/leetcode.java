package easy;


/**
 * Author:maslke
 * Date:2018/12/27 
 * Version:0.0.1 
 * 896. Monotonic Array
 */

 public class lc896 {
     private int test(int a, int b) {
         if (a == b) return 0;
         if (a < b) return 1;
         return -1;
     }

     public boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len <= 2) return true;
        int m = test(A[0], A[len - 1]);
        for (int i = 1; i < len; i++) {
            if (A[i - 1] == A[i]) continue;
            if (m != test(A[i - 1], A[i])) {
                return false;
            }
        }
        return true ;
    }
 }