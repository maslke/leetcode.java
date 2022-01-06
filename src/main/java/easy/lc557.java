package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author:maslke
 * Date:2017/8/29
 * Version:0.0.1
 * 557. Reverse Words in a String III
 */
public class lc557 {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int length = s.length();
        int i = 0, j = length - 1;
        char[] chars = s.toCharArray();
        while (i <= j) {
            int k = i + 1;
            while (k <= j) {
                if (chars[k] == ' ') {
                    break;
                }
                k++;
            }
            int m = i, n = k - 1;
            while (m <= n) {
                char c = chars[m];
                chars[m] = chars[n];
                chars[n] = c;
                m++;
                n--;
            }
            i = k + 1;
        }
        return new String(chars);
    }
}
