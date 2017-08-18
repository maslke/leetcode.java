package main.easy;

/**
 * Author:maslke
 * Date:2017/8/18
 * Version:0.0.1
 * 344. Reverse String
 */
public class lc344 {
    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i <= j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return new String(chars);
    }
}
