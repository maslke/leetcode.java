package medium;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
// 240. Search a 2D Matrix II

class lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            int v = matrix[i][j];
            if (v == target) return true;
            if (v < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}