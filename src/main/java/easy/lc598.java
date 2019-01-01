/**
 * https://leetcode.com/problems/range-addition-ii/   
 * 598. Range Addition II
 */
public class lc598 {
    public int maxCount(int m, int n, int[][] ops) {
        int row = ops.length;
        if (row == 0) {
            return m * n;
        }
        int min1 = m, min2 = n;
        for (int[] op : ops) {
            if (min1 > op[0]) {
                min1 = op[0];
            }
            if (min2 > op[1]) {
                min2 = op[1];
            }
        }
        return min1 * min2;
    }
}
