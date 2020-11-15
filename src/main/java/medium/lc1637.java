package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/widest-vertical-area-between-two-points-containing-no-points/
// 1637. 两点之间不包含任何点的最宽垂直面积
// 莫名其妙的题，感觉题目可以更深挖掘一些。y的坐标是否在构成矩形之内，可能会影响最大矩形

public class lc1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xs = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xs[i] = points[i][0];
        }

        Arrays.sort(xs);
        int max = xs[1] - xs[0];
        for (int i = 2; i < xs.length; i++) {
            max = Math.max(max, xs[i] - xs[i - 1]);
        }
        return max;
    }
}
