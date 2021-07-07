package medium;

import java.util.HashMap;
import java.util.Map;
// https://leetcode-cn.com/problems/count-good-meals/
// 1711. 大餐计数

public class lc1711 {
    public int countPairs(int[] deliciousness) {
        int f = 1000000007;
        int[] values = new int[22];
        values[0] = 1;
        for (int i = 1; i <= 21; i++) {
            values[i] = values[i - 1] * 2;
        }

        Map<Integer, Long> map = new HashMap<>();
        for (int d : deliciousness) {
            map.put(d, map.getOrDefault(d, 0L) + 1);
        }
        long ret = 0;
        long ret2 = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            int key = entry.getKey();
            for (int i = 0; i < values.length; i++) {
                int left = values[i] - key;
                if (left < 0) {
                    continue;
                }
                if (map.containsKey(left)) {
                    if (key == left) {
                        long val = entry.getValue();
                        if (val == 1) {
                            continue;
                        }
                        ret = (val * (val - 1) / 2 + ret) % f;
                    }
                    else {
                        long val1 = entry.getValue();
                        long val2 = map.get(left);
                        ret2 = (val1 * val2 + ret2) % f;

                    }
                }
            }
        }
        return ((int) ret + (int) ret2 / 2) % f;
    }
}
