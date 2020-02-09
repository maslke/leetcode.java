package medium;

// https://leetcode.com/problems/angle-between-hands-of-a-clock/
// 1344. Angle Between Hands of a Clock

class lc1344 {
    public double angleClock(int hour, int minutes) {
        double[] hours = new double[13];
        for (int i = 1; i <= 12; i++) {
            hours[i] = i * 30;
        }
        hours[12] = 0;
        double h = hours[hour] + minutes / 2.0;
        double m = minutes * 6.0;
        double ret = 0;
        if (h > m) {
            ret = h - m;
        } else {
            ret = m - h;
        }
        if (ret > 180.0) {
            ret = 360.0 - ret;
        }
        return ret;
    }
}