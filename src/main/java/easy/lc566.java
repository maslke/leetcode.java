package easy;

// https://leetcode-cn.com/problems/reshape-the-matrix/
// 566. 重塑矩阵

public class lc566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ret = new int[r][c];

        int inx = 0;
        while (inx < m * n) {
            ret[inx / c][inx % c] = nums[inx / n][inx % n];
            inx++;
        }

        return ret;
    }
}
