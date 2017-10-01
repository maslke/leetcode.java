package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/10/1
 * Version:0.0.1
 * 677. Map Sum Pairs
 */
public class lc677 {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public lc677() {
        map = new HashMap<String, Integer>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int count = 0;
        for (String key: map.keySet()) {
            if (key.indexOf(prefix) == 0) {
                count += map.get(key);
            }
        }
        return count;
    }
}
