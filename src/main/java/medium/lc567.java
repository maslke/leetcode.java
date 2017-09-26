package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/26
 * Version:0.0.1
 * 567. Permutation in String
 */
public class lc567 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        Map<Character, Integer> map1 = getMap(s1);
        Map<Character, Integer> map2 = null;
        for (int i = 0; i < len2; i++) {
            if (i + len1 <= len2) {
                if (map2 == null) {
                    map2 = getMap(s2.substring(i, i + len1));
                } else {
                    int count = map2.get(s2.charAt(i - 1));
                    if (count == 1) {
                        map2.remove(s2.charAt(i - 1));
                    } else {
                        map2.put(s2.charAt(i - 1), count - 1);
                    }
                    char c = s2.charAt( i - 1 + len1);
                    if (map2.containsKey(c)) {
                        map2.put(c, 1 + map2.get(c));
                    } else {
                        map2.put(c, 1);
                    }
                }
                if (isAnagram(map1, map2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Map<Character, Integer> getMap(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, 1 + map.get(c));
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private boolean isAnagram(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.keySet().size() != map2.keySet().size()) {
            return false;
        }
        for (Character key: map1.keySet()) {
            if (!map2.containsKey(key)) {
                return false;
            }
            if (map1.get(key) - map2.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
