package hard;

// https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
// 84. 柱状图中最大的矩形

import java.util.Stack;

public class lc84 {
    // brute force
    public int largestRectangleArea(int[] heights) {
        int ret = 0;
        for (int i = 0; i < heights.length; i++) {

            int count = 1;
            int m = i - 1;
            while (m >= 0) {
                if (heights[m] >= heights[i]) {
                    count++;
                    m--;
                } else {
                    break;
                }
            }
            int n = i + 1;
            while (n < heights.length) {
                if (heights[n] >= heights[i]) {
                    count++;
                    n++;
                } else {
                    break;
                }
            }

            ret = Math.max(ret, count * heights[i]);

        }

        return ret;

    }

    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int ret = 0;
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);

        heights = newHeights;
        len = len + 2;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peek()]) {
                int inx = stack.pop();
                ret = Math.max(ret, heights[inx] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return ret;

    }
}
