package medium;

import java.util.Arrays;


// https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
// 452. 用最少数量的箭引爆气球

public class lc452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            }
            else if (a[0] == b[0]) {
                return 0;
            }
            else {
                return 1;
            }
        });
        int ret = 1;
        int a = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] b = points[i];
            if (a < b[0]) {
                ret++;
                a = b[1];
            }
            else {
                a = Math.min(a, b[1]);
            }
        }
        return ret;
    }
}
