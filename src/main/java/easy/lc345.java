package easy;

/**
 * Author:maslke
 * Date:2017/8/28
 * Version:0.0.1
 * 345. Reverse Vowels of a String
 */
public class lc345 {
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        String target = "AEIOUaeiou";
        int length = s.length();
        char[] chars = s.toCharArray();
        int i = 0, j = length - 1;
        while (i <= j) {
            char c = chars[i];
            if (target.indexOf(c) >= 0) {
                int k = j;
                for (; k > i; k--) {
                    if (target.indexOf(chars[k]) >= 0) {
                        break;
                    }
                }
                if (k == i) {
                    break;
                } else {
                    char temp = chars[i];
                    chars[i] = chars[k];
                    chars[k] = temp;
                    i++;
                    j = k - 1;
                }
            } else {
                i++;
            }
        }
        return new String(chars);
    }
}
