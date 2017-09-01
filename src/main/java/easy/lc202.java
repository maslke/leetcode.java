package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/1
 * Version:0.0.1
 * 202. Happy Number
 */
public class lc202 {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (n != 1) {
            if (map.containsKey(n)) {
                return false;
            } else {
                map.put(n, 1);
            }
            int m = n;
            int ret = 0;
            while (m != 0) {
                ret += Math.pow(m % 10, 2);
                m = m / 10;
            }
            n = ret;
        }
        return true;
    }
}
