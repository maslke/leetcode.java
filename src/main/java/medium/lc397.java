package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/3
 * Version:0.0.1
 * 397. Integer Replacement
 */
public class lc397 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        map.put(1, 0);
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int count = 0;
        if (n % 2 == 0) {
            int count1 = integerReplacement( n / 2);
            map.put(n / 2, count1);
            count = 1 + count1;
        } else {
            int count2 = 1 + integerReplacement(n / 2 + 1);
            int count3 = integerReplacement(n - 1);
            map.put(n / 2 + 1, count2 - 1);
            map.put(n - 1, count3);
            count = 1 + Math.min(count2, count3);
        }
        map.put(n, count);
        return count;
    }
}
