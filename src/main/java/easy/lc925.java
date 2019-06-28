package easy;

/**
 * https://leetcode.com/problems/long-pressed-name/
 * lc.925
 */
class lc925 {
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        int i = 0;
        int j = 0;
        while (i < len1 || j < len2) {
            if (i >= len1 || j >= len2) return false;
            char c = name.charAt(i);
            int m = i;
            while (m < len1) {
                if (name.charAt(m) != c) {
                    break;
                }
                m++;
            }
            int l1 = m - i + 1;
            i = m;
            char c2 = typed.charAt(j);
            int n = j;
            while(n < len2) {
                if (typed.charAt(n) != c2) {
                    break;
                }
                n++;
            }
            int l2 = n - j + 1;
            j = n;
            if (c != c2 || l2 < l1) {
                return false;
            }
            
        }
        return true;
    }
}