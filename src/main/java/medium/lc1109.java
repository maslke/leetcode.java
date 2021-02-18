package medium;

// https://leetcode-cn.com/problems/corporate-flight-bookings/
// 1109. 航班预定统计

public class lc1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ret = new int[n];
        for (int[] booking : bookings) {
            ret[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ret[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            ret[i] = ret[i] + ret[i - 1];
        }

        return ret;
    }
}
