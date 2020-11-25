package easy;

// https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix/
// 1582. 二进制矩阵中的特殊位置

public class lc1582 {

    public int numSpecial(int[][] mat) {

        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }


        int ret = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
