package easy;

import java.util.Arrays;
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

    public int findLucky2(int[] arr) {
        Arrays.sort(arr);
        int i = arr.length - 1;
        while (i >= 0) {
            int m = i;
            int v = arr[i];
            while (m >= 0) {
                if (arr[m] != v) break;
                m--;
            }
            if (i - m == v) {
                return v;
            }
            i = m;
        }
        return -1;
    }
}