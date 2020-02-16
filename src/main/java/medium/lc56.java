package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
// 56. Merge Intervals
class lc56 {
    public int[][] merge(int[][] intervals) {
        sort(intervals, 0, intervals.length - 1);
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = intervals.length - 1;
        while (i <= j) {
            int begin = intervals[i][1];
            int m = i;
            while (true) {
                if (m + 1 > j) break;
                if (intervals[m + 1][0] > begin) {
                    break;
                } else {
                    m = m + 1;
                    begin = Math.max(intervals[m][1], begin);
                }
            }
            
            list.add(new int[]{ intervals[i][0], begin});
            i = m + 1;
        }
        int[][] ret = new int[list.size()][2];
        for (int inx = 0; inx < list.size(); inx++) {
            ret[inx] = list.get(inx);
        }
        return ret;
        
    }
    
    private void sort(int[][] intervals, int low, int high) {
        if (low >= high) return;
        int p = partition(intervals, low, high);
        sort(intervals, low, p - 1);
        sort(intervals, p + 1, high);
    }
    
    private int partition(int[][] intervals, int low, int high) {
        int[] m = intervals[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(intervals[++i], m)) {
                if (i == high) break;
            }
            while (less(m, intervals[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(intervals, i, j);
        }
        swap(intervals, low, j);
        return j;
    }
    
    private boolean less(int[] a, int[] b) {
        return a[0] < b[0];
    }
    
    
    
    
    private void swap(int[][] intervals, int i, int j) {
        int a = intervals[i][0];
        int b = intervals[i][1];
        intervals[i][0] = intervals[j][0];
        intervals[i][1] = intervals[j][1];
        intervals[j][0] = a;
        intervals[j][1] = b;
    }
}