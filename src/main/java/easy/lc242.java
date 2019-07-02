package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * Author:maslke Date:2017/9/6 Version:0.0.1 242. Valid Anagram
 */
public class lc242 {

    public boolean isAnagram2(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return Arrays.equals(sa, ta);
    }

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
            char c1 = t.charAt(i);
            if (map2.containsKey(c1)) {
                map2.put(c1, map2.get(c1) + 1);
            } else {
                map2.put(c1, 1);
            }
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
