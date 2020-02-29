package easy;

// https://leetcode-cn.com/problems/meeting-rooms/
// 252. 会议室
class lc252 {
    public boolean canAttendMeetings(int[][] intervals) {
        sort(intervals, 0, intervals.length - 1);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] - intervals[i - 1][1] < 0) {
                return false;
            }
        }
        return true;
    }

    private void sort(int[][] vs, int low, int high) {
        if (low >= high) return;
        int p = partition(vs, low, high);
        sort(vs, low, p - 1);
        sort(vs, p + 1, high);
    }

    private boolean less(int[] a, int[] b) {
        if (a[0] < b[0]) return true;
        if (a[0] > b[0]) return false;
        return a[1] < b[1];
    }

    private void swap(int[][] vs, int i, int j) {
        int[] temp = vs[i];
        vs[i] = vs[j];
        vs[j] = temp;
    }

    private int partition(int[][] vs, int low, int high) {
        int[] m = vs[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(vs[++i], m)) {
                if (i == high) break;
            }
            while (less(m, vs[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(vs, i, j);
        }
        swap(vs, j, low);
        return j;
    }
}