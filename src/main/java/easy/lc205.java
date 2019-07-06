package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke Date:2017/9/26 Version:0.0.1 205. Isomorphic Strings
 */
public class lc205 {

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map.containsKey(cs) && map.get(cs) != ct)
                return false;
            if (map2.containsKey(ct) && map2.get(ct) != cs)
                return false;
            map.put(cs, ct);
            map2.put(ct, cs);
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 != len2) {
            return false;
        }
        Map<String, String> map1 = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();
        for (int i = 0; i < len1; i++) {
            String s1 = s.substring(i, i + 1);
            String s2 = t.substring(i, i + 1);
            if (map1.containsKey(s1)) {
                if (!map1.get(s1).equals(s2)) {
                    return false;
                }
            } else {
                map1.put(s1, s2);
                if (map2.containsKey(s2) && !map2.get(s2).equals(s1)) {
                    return false;
                }
                map2.put(s2, s1);
            }
        }
        return true;
    }
}
