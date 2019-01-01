/**
 * Author:maslke
 * Date:2017/9/17
 * Version:0.0.1
 * 661. Image Smoother
 */
public class lc661 {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int column = M[0].length;
        int[][] ret = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int count = 1;
                int v = M[i][j];
                if (i - 1 >= 0) {
                    count++;
                    v = v + M[i - 1][j];
                }
                if (i + 1 < row) {
                    count++;
                    v = v + M[i + 1][j];
                }
                if (j - 1 >= 0) {
                    count++;
                    v = v + M[i][j - 1];
                }
                if (j + 1 < column) {
                    count++;
                    v = v + M[i][j + 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    count++;
                    v = v + M[i - 1][j - 1];
                }
                if (i - 1 >= 0 && j + 1 < column) {
                    count++;
                    v = v + M[i - 1][j + 1];
                }
                if (i + 1 < row && j - 1 >= 0) {
                    count++;
                    v = v + M[i + 1][j - 1];
                }
                if (i + 1 < row && j + 1 < column) {
                    count++;
                    v = v + M[i + 1][j + 1];
                }
                ret[i][j] = (int)(v / count);
            }
        }
        return ret;
    }
}
