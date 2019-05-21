package easy;

import java.util.Map;
import java.util.HashMap;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 70. Climbing Stairs
 */
public class lc70 {
    Map<Integer, Integer> map;
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        return getN(n);
    }

    private int getN(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int v1 = getN(n - 1);
            int v2 = getN(n - 2);
            map.put(n, v1 + v2);
            return v1 + v2;
        }
    }
}
