
package easy;

import java.util.Arrays;

// https://leetcode.com/problems/largest-perimeter-triangle/
// 976. Largest Permeter Triangle

class lc976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        for (int i = length - 3; i >= 0; i--) {
            if (A[i + 2] < A[i + 1] + A[i]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }
}