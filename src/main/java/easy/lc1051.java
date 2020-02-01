package easy;

import java.util.Arrays;

class lc1051 {
    public int heightChecker(int[] heights) {
        int[] data = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            data[i] = heights[i];
        }
        Arrays.sort(data);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (data[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}