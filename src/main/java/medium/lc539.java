package medium;

// https://leetcode-cn.com/problems/minimum-time-difference/
// 539. 最小时间差

import java.util.Arrays;
import java.util.List;

public class lc539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] parts = timePoints.get(i).split(":");
            times[i] =  Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }


        Arrays.sort(times);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < times.length; i++) {
            int a = times[i - 1];
            int b = times[i];
            min = Math.min(b - a, min);
        }

        min = Math.min(min, times[0] + 24 * 60 - times[times.length - 1]);
        return min;
    }
}
