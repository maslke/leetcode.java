package medium;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode-cn.com/problems/hand-of-straights/
// 846. 一首顺子

public class lc846 {
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if (n % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : hand) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            int key = entry.getKey();
            int value = entry.getValue();
            map.remove(key);
            for (int i = 1; i < W; i++) {
                int value2 = map.getOrDefault(key + i, 0);
                if (value2 < value) {
                    return false;
                }
                else if (value == value2) {
                    map.remove(key + i);
                }
                else {
                    map.replace(key + i, value2 - value);
                }
            }
        }
        return true;

    }
}
