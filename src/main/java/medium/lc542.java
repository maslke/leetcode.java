package medium;

// https://leetcode-cn.com/problems/01-matrix/
// 542. 01矩阵

class lc542 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] ret = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    ret[i][j] = 10000;  
                }
                if (i > 0) {
                        ret[i][j] = Math.min(ret[i][j], ret[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        ret[i][j] = Math.min(ret[i][j], ret[i][j - 1] + 1);
                    }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (i < matrix.length - 1) {
                        ret[i][j] = Math.min(ret[i][j], ret[i + 1][j] + 1);
                    }
                    if (j < matrix[i].length - 1) {
                        ret[i][j] = Math.min(ret[i][j], ret[i][j + 1] + 1);
                    }
        
            }
        }
        return ret;
    }
}