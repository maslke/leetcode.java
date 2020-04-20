package medium;

// https://leetcode.com/problems/minimum-falling-path-sum/
// 931. Minimum Falling Path Sum

class lc931 {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
                } else if (j == n - 1) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
                } else {
                    A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][j - 1], A[i - 1][j + 1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (min > A[m - 1][j]) {
                min = A[m - 1][j];
            }
        }    
        return min;
    }
}