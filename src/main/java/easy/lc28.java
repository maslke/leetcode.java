package easy;

/**
 * Author:maslke
 * Date:2017/9/3
 * Version:0.0.1
 * 28. Implement strStr()
 */
public class lc28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        int i = 0;
        while (i < len1) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int m = i, n = 0;
                while (m < len1 && n < len2) {
                    if (haystack.charAt(m) == needle.charAt(n)) {
                        m++;
                        n++;
                    } else {
                        break;
                    }
                }
                if (n == len2 && m <= len1) {
                    return i;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return -1;
    }
}
