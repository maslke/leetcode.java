package medium;

import java.util.Map;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.HashMap;

// https://leetcode.com/problems/time-based-key-value-store/
// 981. Time Based Key-Value Store
class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;
    private Comparator<Integer> comparator;

    public TimeMap() {
        map = new HashMap<>();
        comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> treeMap = new TreeMap<>(comparator);
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        }
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> treeMap = map.get(key);
            for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
                if (entry.getKey() <= timestamp) {
                    return entry.getValue();
                }
            }
            return "";
        } else {
            return "";
        }
    }
}
