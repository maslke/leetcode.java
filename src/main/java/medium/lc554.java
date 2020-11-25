package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/brick-wall/
// 554. 砖墙

public class lc554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int size = wall.size();
        int max = 0;
        for (Integer value : map.values()) {
            if (max < value) {
                max = value;
            }
        }
        return size - max;
    }
}
