package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/isomorphic-strings/
// 205. 同构字符串

public class lc205 {

    public boolean isIsomorphic(String s, String t) {
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (arr1[c1] != -1) {
                if (arr1[c1] != c2) {
                    return false;
                }
            } else {
                arr1[c1] = c2;
            }
            if (arr2[c2] != -1) {
                if (arr2[c2] != c1) {
                    return false;
                }
            } else {
                arr2[c2] = c1;
            }
        }
        return true;
    }

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
}
