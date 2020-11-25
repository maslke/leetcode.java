package medium;

import java.util.LinkedHashMap;


// https://leetcode-cn.com/problems/lru-cache-lcci/
// 面试题 16.25. LRU缓存

public class LRUCache {

    private int capacity;

    private LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        this.linkedHashMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {

        if (linkedHashMap.containsKey(key)) {
            int value = linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return value;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
        }
        else {
            linkedHashMap.put(key, value);
            if (linkedHashMap.size() > capacity) {
                linkedHashMap.remove(linkedHashMap.entrySet().iterator().next().getKey());
            }
        }
    }
}
