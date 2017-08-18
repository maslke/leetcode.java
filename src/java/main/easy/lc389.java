package main.easy;

/**
 * Author:maslke
 * Date:2017/8/18
 * Version:0.0.1
 * 389. Find the Difference
 */
public class lc389 {
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
