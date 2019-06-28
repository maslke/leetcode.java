package easy;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 * 941. Valid Mountain Array
 */
class lc941 {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        int j = A.length;
        if (j < 3) return false;
        while (i < j - 1 && A[i] < A[i + 1] ) {
            i++;
        }
        if (i== 0 || i == j - 1) return false;
        while (i < j - 1) {
            if (A[i] <= A[i + 1]) return false;
            i++;
        }
        return true;
    }
}