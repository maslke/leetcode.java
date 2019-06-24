package easy;

import java.util.Map;
import java.util.HashMap;

/**
 * 953. Verifying an Alien Dictionary
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 *
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String current = words[i];
            if (!isValid(prev, current, map)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(String prev, String current, Map<Character, Integer> map) {
        int i = 0;
        int j = 0;
        int len1 = prev.length();
        int len2 = current.length();
        while (i < len1 || j < len2) {
            if (i >= len1) {
                return true;
            }
            if (j >= len2) {
                return false;
            }
            int index1 = map.get(prev.charAt(i));
            int index2 = map.get(current.charAt(j));
            if (index1 == index2) {
                i++;
                j++;
            } else if (index1 < index2) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}