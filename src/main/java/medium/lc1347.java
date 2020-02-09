package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
// 1347. Minimum Number of Steps to Make Two Strings Anagram
class Solution {
    public int minSteps(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (map.containsKey(cs[i])) {
                map.put(cs[i], map.get(cs[i]) + 1);
            } else {
                map.put(cs[i], 1);
            }
        }
        int count = 0;
        for (int i = 0; i < ct.length; i++) {
                if (map.containsKey(ct[i])) {
                    if (map.get(ct[i]) == 1) {
                        map.remove(ct[i]);
                    } else {
                        map.put(ct[i], map.get(ct[i]) - 1);
                    }
                } else {
                    count++;
                }
        }
        return count;
    }
}