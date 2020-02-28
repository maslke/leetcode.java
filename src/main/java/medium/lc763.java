package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/partition-labels/
// 763. Partition Labels

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int length = S.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            }
        }
        
        int i = 0;
        while (i < length) {
            char c = S.charAt(i);
            if (map.get(c) == i) {
                result.add(1);
                i++;
            } else {
                int max = map.get(c);
                int m = i;
                while (m < max) {
                    char c1 = S.charAt(m);
                    max = Math.max(map.get(c1), max);
                    m++;
                }
                result.add(m - i + 1);
                i = m + 1;
            }
        }
        return result;
    }
}