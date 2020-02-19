package medium;

// https://leetcode.com/problems/search-a-2d-matrix/
// 74. Search a 2D Matrix

public class lc74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            int v = matrix[i][j];
            if (v == target) return true;
            if (v < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
