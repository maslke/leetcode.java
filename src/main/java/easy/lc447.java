package easy;

import java.util.Map;
import java.util.HashMap;


// https://leetcode.com/problems/number-of-boomerangs/
// 447. Number of Boomeranges
class lc447 {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                    + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (map.containsKey(distance)) {
                    map.put(distance, map.get(distance) + 1);
                } else {
                    map.put(distance, 1);
                }
            }
            for (Integer cnt : map.values()) {
                if (cnt > 1) {
                    count = getPairsCount(cnt) + count;
                }
            }
        }
        return count;
    }
    
    private int getPairsCount(int count) {
        int ret = 1;
        for (int i = 1; i <= count; i++) {
            ret = ret * i;
        }
        for (int i = 1; i <= count - 2; i++) {
            ret = ret / i;
        }
        return ret;
    }
} 