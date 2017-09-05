package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 409. Longest Palindrome
 */
public class lc409 {
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int len = 0;
        boolean flag = false;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                len += map.get(c);
            } else {
                flag = true;
                len += map.get(c) - 1;
            }
        }
        return flag ? len + 1 : len;
    }
}
