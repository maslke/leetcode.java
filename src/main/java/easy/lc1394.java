package easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-lucky-integer-in-an-array/
// 1394. Find Lucky Integer in an Array


class lc1394 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }    
        int ret = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                ret = Math.max(ret, entry.getKey());
            }
        
        }
        return ret;
    }
}