package hard;

import java.util.Arrays;

// https://leetcode-cn.com/problems/maximum-gap/
// 164. 最大间距
// mark

public class lc164 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        if (n == 2) {
            return max - min;
        }
        int d = Math.max((max - min) / (n - 1), 1);
        int bucketSize = (max - min) / d + 1;

        int[][] values = new int[bucketSize][2];
        for (int i = 0; i < values.length; i++) {
            Arrays.fill(values[i], -1);
        }
        for (int i = 0; i < nums.length; i++) {
            int inx = (nums[i] - min) / d;
            if (values[inx][0] == -1) {
                values[inx][0] = nums[i];
                values[inx][1] = nums[i];
            } else {
                values[inx][0] = Math.min(values[inx][0], nums[i]);
                values[inx][1] = Math.max(values[inx][1], nums[i]);
            }
        }
        int prev = -1;
        int ret = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i][0] == -1) {
                continue;
            }
            // 最达间距发生在两个桶之间，不会发生在内部
            if (prev != -1) {
                ret = Math.max(ret, values[i][0] - values[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
}
