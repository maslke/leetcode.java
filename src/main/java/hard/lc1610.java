package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// https://leetcode-cn.com/problems/maximum-number-of-visible-points/
// 1610. 可见点的最大数目
public class lc1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int same = 0;
        for (List<Integer> point : points) {
            if (Objects.equals(location.get(0), point.get(0)) && Objects.equals(location.get(1), point.get(1))) {
                same++;
                continue;
            }
            // atan2覆盖的范围是[-PI,PI]
            angles.add(Math.atan2(location.get(1) - point.get(1), location.get(0) - point.get(0)));
        }
        Collections.sort(angles);
        int size = angles.size();
        for (int i = 0; i < size; i++) {
            angles.add(angles.get(i) + Math.PI * 2);
        }
        int max = 0;
        int len = angles.size();
        double deg = angle * 1.0 / 180 * Math.PI;


        //
        int i = 0;
        int j = 0;
        while (i < size && j < len) {
            double d = angles.get(i) + deg;
            if (angles.get(j) <= d) {
                j++;
            }
            else {
                max = Math.max(max, j - i);
                i++;
            }
        }
        return max + same;
    }
}
