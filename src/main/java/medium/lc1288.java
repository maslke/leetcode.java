package medium;


import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/remove-covered-intervals/
// 1288. Remove Covered Intervals

class lc1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (e1, e2) -> {
            if(e1[0] < e2[0]) return -1;
            if(e2[0] < e1[0]) return 1;
            if(e1[1] > e2[1]) return -1;
            return 1;
        });
        
        int count = 1;
        int[] prev = intervals[0];
        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= prev[0] && intervals[i][1] <= prev[1]) continue;
            prev = intervals[i];
            count++;
        }
        return count;
    }
}