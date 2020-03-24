package easy;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/longest-harmonious-subsequence/
// 594. Longest Harmonious Subsequence

class lc594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        Map.Entry<Integer, Integer> one = null;
        int length = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (one == null) {
                one = entry;
            } else {
                if (entry.getKey() - one.getKey() == 1) {
                    length = Math.max(length, entry.getValue() + one.getValue());
                }
                one = entry;
            }
        }
        return length;
    }
}