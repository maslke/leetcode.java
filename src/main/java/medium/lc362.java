package medium;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode-cn.com/problems/design-hit-counter/
// 362. 敲击计数器

class HitCounter {

    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.map = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
    
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
    
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (timestamp - entry.getKey() < 300) {
                    count += entry.getValue();
                }
            }
            return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */