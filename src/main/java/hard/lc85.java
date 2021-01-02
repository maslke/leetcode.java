package hard;

// https://leetcode-cn.com/problems/maximal-rectangle/
// 85. 最大矩形

import java.util.ArrayDeque;
import java.util.Deque;

public class lc85 {
    public int maximalRectangle(char[][] matrix) {
        int ret = 0;
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] heights = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                for (int inx = 0; inx < matrix[i].length; inx++) {
                    heights[i][inx] = matrix[i][inx] - '0';
                }
            } else {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == '1') {
                        heights[i][j] += 1 + heights[i - 1][j];
                    }
                }

            }
            ret = Math.max(ret, max(heights[i]));
        }
        return ret;
    }

    private int max(int[] heights) {
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int ret = 0;
        heights = newHeights;
        for (int i = 1; i < heights.length; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int inx = stack.removeLast();
                ret = Math.max(ret, heights[inx] * (i - 1 - stack.peekLast()));
            }
            stack.addLast(i);
        }
        return ret;
    }
}
