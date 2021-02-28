package easy;

// https://leetcode-cn.com/problems/flipping-an-image/
// 832. 翻转图像

public class lc832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int m = 0;
            int n = length - 1;
            while (m <= n) {
                int temp = A[i][m] ^ 1;
                A[i][m] = A[i][n] ^ 1;
                A[i][n] = temp;
                m++;
                n--;
            }
        }
        return A;
    }
}
