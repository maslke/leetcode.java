package easy;


// https://leetcode-cn.com/problems/monotonic-array/
// 896. 单调数列

public class lc896 {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }

        boolean asc = false;
        boolean dec = false;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                asc = true;
            }
            if (A[i] < A[i - 1]) {
                dec = true;
            }
            if (asc && dec) {
                return false;
            }
        }

        return true;
    }
}