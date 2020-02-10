package medium;

// https://leetcode.com/problems/matrix-block-sum/
// 1314. Matrix Block Sum

class lc1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] ret = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                ret[i][j] = sum(i, j , K, mat);
            }
        }
        return ret;
    }
    
    private int sum(int i, int j, int K, int[][] mat) {
        int a = mat.length;
        int b = mat[0].length;
        int sum = 0;
        for (int m = i - K; m <= i + K; m++) {
            for (int n = j - K; n <= j + K; n++) {
                if (m >= 0 && m < a && n >= 0 && n < b) {
                    sum += mat[m][n];
                }
            }
        }
        return sum;
    }
}