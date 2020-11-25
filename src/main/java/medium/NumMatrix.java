package medium;

// leetcode-304
// https://leetcode-cn.com/problems/range-sum-query-2d-immutable

public class NumMatrix {



    public int sumRegion2(int row1, int col1, int row2, int col2) {

        return acc[row2 + 1][col2 + 1] + acc[row1][col1] - acc[row1][col2 + 1] - acc[row2 + 1][col1];
    }



    int[][] acc;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            acc = new int[0][0];
        }
        else {
            acc = new int[matrix.length][matrix[0].length];
            acc[0][0] = matrix[0][0];
            for (int i = 1; i < matrix[0].length; i++) {
                acc[0][i] = matrix[0][i] + acc[0][i - 1];
            }
            for (int i = 1; i < matrix.length; i++) {
                acc[i][0] = acc[i - 1][0] + matrix[i][0];
            }

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + matrix[i][j];
                }
            }
        }

        // if (matrix.length == 0) {
        //            acc = new int[0][0];
        //        } else {
        //            int m = matrix.length;
        //            int n = matrix[0].length;
        //            acc = new int[m + 1][n + 1];
        //            for (int i = 1; i <= matrix.length; i++) {
        //                for (int j = 1; j <= matrix[i].length; j++) {
        //                    acc[i][j] = matrix[i - 1][j - 1] - acc[i - 1][j - 1] + acc[i - 1][j] + acc[i][j - 1];
        //                }
        //            }
        //        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return acc[row2][col2];
        }
        else if (row1 == 0) {
            return acc[row2][col2] - acc[row2][col1 - 1];
        }
        else if (col1 == 0) {
            return acc[row2][col2] - acc[row1 - 1][col2];
        }

        return acc[row2][col2] + acc[row1 - 1][col1 - 1] - acc[row1 - 1][col2] - acc[row2][col1 - 1];
    }

}
