package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/26
 * Version:0.0.1
 * 438. Find All Anagrams in a String
 */
public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<Integer>();
        int len = p.length();
        Map<Character, Integer> map1 = getMap(p);
        Map<Character, Integer> map2 = null;
        for (int i = 0; i < s.length(); i++) {
            if (i + len <= s.length()) {
                if (map2 == null) {
                    map2 = getMap(s.substring(i, i + len));
                } else {
                    int c = map2.get(s.charAt(i - 1));
                    if (c == 1) {
                        map2.remove(s.charAt(i - 1));
                    } else {
                        map2.put(s.charAt(i - 1), c - 1);
                    }
                    if (map2.containsKey(s.charAt(i + len - 1))) {
                        map2.put(s.charAt(i + len - 1), 1 + map2.get(s.charAt(i + len - 1)));
                    } else {
                        map2.put(s.charAt(i + len - 1), 1);
                    }
                }
                if (isAnagram(map1, map2)) {
                    ret.add(i);
                }
            } else {
                break;
            }
        }
        return ret;
    }

    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        return map;
    }

    private boolean isAnagram(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.keySet().size() != map2.keySet().size()) {
            return false;
        }
        for (Character key : map1.keySet()) {
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
