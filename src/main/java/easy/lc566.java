package easy;

/**
 * Author:maslke
 * Date:2017/9/26
 * Version:0.0.1
 * 566. Reshape the Matrix
 */
public class lc566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int[][] ret = new int[r][c];
        int inx1 = 0, inx2 = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (inx2 < c) {
                    ret[inx1][inx2] = nums[i][j];
                    inx2++;
                } else {
                    inx2 = 0;
                    inx1++;
                    ret[inx1][inx2] = nums[i][j];
                    inx2++;
                }
            }
        }
        return ret;
    }
}
