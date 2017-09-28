package easy;

/**
 * Author:maslke
 * Date:2017/9/28
 * Version:0.0.1
 * 598. Range Addition II
 */
public class lc598 {
    public int maxCount(int m, int n, int[][] ops) {
        int max = 0;
        int row = ops.length;
        if (row == 0) {
            return m * n;
        }
        int min1 = m, min2 = n;
        for (int i = 0; i< ops.length; i++) {
            if (min1 > ops[i][0]) {
                min1 = ops[i][0];
            }
            if (min2 > ops[i][1]) {
                min2 = ops[i][1];
            }
        }
        return min1 * min2;
    }
}
