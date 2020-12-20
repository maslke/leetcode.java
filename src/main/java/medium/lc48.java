package medium;

// https://leetcode-cn.com/problems/rotate-image/
// 48. 旋转图像

public class lc48 {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            int m = 0;
            int n = matrix[i].length - 1;
            while (m < n) {
                int temp = matrix[i][m];
                matrix[i][m] = matrix[i][n];
                matrix[i][n] = temp;
                m++;
                n--;
            }
        }

        int n = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            int m = matrix.length - 1;
            for (int j = 0; j <= n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m][n];
                matrix[m][n] = temp;
                m--;
            }
            n--;
        }
    }
}
