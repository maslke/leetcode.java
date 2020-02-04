package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/reduce-array-size-to-the-half/
// 1338. Reduce Array Size to The Half

class lc1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        Map<Integer, Integer> map2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (map2.containsKey(value)) {
                map2.put(value, map2.get(value) + 1);
            } else {
                map2.put(value, 1);
            }
        }
        
        int sum = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            for (int i = 1; i <= value; i++) {
                sum += key;
                count++;
                if (sum * 2 >= length) return count;
            }
        }
        
       return 0;
        
       
    }
}