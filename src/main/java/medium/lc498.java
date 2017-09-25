package medium;

/**
 * Author:maslke
 * Date:2017/9/26
 * Version:0.0.1
 * 498. Diagonal Traverse
 * 仔细分析，情况好像问题就变得简单了
 */
public class lc498 {
    public int[] findDiagonalOrder(int[][] matrix) {

        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        int inx = 0;
        int[] ret = new int[row * col];
        int i = 0 , j = 0;
        boolean flag = true;
        while (i < row && j < col) {
            ret[inx++] = matrix[i][j];
            if (inx == row * col) {
                break;
            }
            if (flag) {
                if (i == 0) {
                    if (j == col - 1) {
                        i = i + 1;
                        flag = !flag;
                    } else {
                        j = j + 1;
                        flag = !flag;
                    }
                } else if (j == col - 1) {
                    i = i + 1;
                    flag = !flag;
                } else {
                    i = i - 1;
                    j = j + 1;
                }
            } else {
                if (j == 0) {
                    if (i == row - 1) {
                        j = j + 1;
                        flag = !flag;
                    } else {
                        i = i + 1;
                        flag = !flag;
                    }
                }  else if (i == row - 1) {
                    j = j + 1;
                    flag = !flag;
                } else {
                    i = i + 1;
                    j = j - 1;
                }
            }

        }
        return ret;
    }
}
