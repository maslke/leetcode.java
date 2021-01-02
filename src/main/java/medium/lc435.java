package medium;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode-cn.com/problems/non-overlapping-intervals/
// 435. 无重叠区间

public class lc435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int first = intervals[0][1];
        int count = 1;
        int i = 1;
        int len = intervals.length;
        while (i < len) {
            int[] b = intervals[i];
            if (b[0] >= first) {
                count++;
                first = b[1];
            }
            i++;
        }
        return len - count;
    }
}
