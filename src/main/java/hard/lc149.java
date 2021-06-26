package hard;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/max-points-on-a-line/
// 149. 直线上最多的点数

public class lc149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                if (deltaX == 0) {
                    deltaY = 1;
                }
                if (deltaY == 0) {
                    deltaX = 1;
                }

                if (deltaX < 0) {
                    deltaX = -1 * deltaX;
                    deltaY = -1 * deltaY;
                }

                int x = Math.abs(deltaX);
                int y = Math.abs(deltaY);
                int gcd = gcd(Math.max(x, y), Math.min(x, y));
                x = deltaX / gcd;
                y = deltaY / gcd;
                String key = x + "-" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (Integer value : map.values()) {
                ret = Math.max(ret, value + 1);
            }
        }
        return ret;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
