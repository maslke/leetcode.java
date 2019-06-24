package medium;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 * 890. Find and Replace Pattern
 */
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.clear();
            map2.clear();
            int j = 0;
            for (; j < pattern.length(); j++) {
                if (map.containsKey(pattern.charAt(j))) {
                    if (map.get(pattern.charAt(j)) != words[i].charAt(j)) {
                        break;
                    }
                } else {
                    map.put(pattern.charAt(j), words[i].charAt(j));
                }
                if (map2.containsKey(words[i].charAt(j))) {
                    if (map2.get(words[i].charAt(j)) != pattern.charAt(j)) {
                        break;
                    }
                } else {
                    map2.put(words[i].charAt(j), pattern.charAt(j));
                }
            }
            if (j == pattern.length()) {
                ret.add(words[i]);
            }
        }
        return ret;
    }
}