package easy;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Author:maslke
 * Date:2017/8/18
 * Version:0.0.1
 * 389. Find the Difference
 */
public class lc389 {

    public char findTheDifferences3(String s, String t) {
        char[] ca = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(ct);
        int i = 0;
        int j = 0;
        while (i < ca.length && j < ct.length) {
            if (ca[i] != ct[j]) {
                return ct[j];
            }
        }
        return ct[ct.length - 1];
    }

    public char findTheDifferences2(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c,1);
            }       
        }

        for (int i = 0; i < t.length(); i++) {
            char c = s.charAt(i);
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 2);
            }
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Character key = entry.getKey();
            int value = entry.getValue();
            if (!map1.containsKey(key) || map1.get(key) - value != 0) {
                return key;
            }
        }
        return ' ';
    }

    public char findTheDifference(String s, String t) {
        if (s == null || s.isEmpty()) {
            return t.charAt(0);
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];
            for (int j = 0; j < tChars.length; j++) {
                if (c == tChars[j] && tChars[j] != '1') {
                    tChars[j] = '1';
                    break;
                }
            }
        }
        for (int i = 0; i < tChars.length; i++) {
            if (tChars[i] != '1') {
                return tChars[i];
            }
        }
        return ' ';
    }
}
