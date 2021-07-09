package medium;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// 378. Kth Smallest Element in a Sorted Matrix
// Mark

class lc378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int count = lessOrEqualCount(matrix, middle);
            if (count < k) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    private int lessOrEqualCount(int[][] matrix, int middle) {
        int i = matrix.length - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < matrix.length) {
            int value = matrix[i][j];
            if (value <= middle) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}