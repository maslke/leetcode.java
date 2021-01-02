package medium;

// https://leetcode-cn.com/problems/score-after-flipping-matrix/
// 861. 反转矩阵后的得分

public class lc861 {
    public int matrixScore(int[][] A) {
        int ret = 0;
        int length = A[0].length;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }
        ret = (int) (Math.pow(2, length - 1)) * A.length;
        for (int i = 1; i < A[0].length; i++) {
            int count = 0;
            for (int[] ints : A) {
                count += ints[i];
            }
            count = Math.max(A.length - count, count);
            ret += (int) ( Math.pow(2, length - 1 - i)) * count;
        }
        return ret;
    }
}
