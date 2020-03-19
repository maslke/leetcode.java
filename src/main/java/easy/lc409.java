package easy;

// https://leetcode-cn.com/problems/longest-palindrome/
// 409. 最长回文串

class lc409 {
    public int longestPalindrome(String s) {
        if (s == null || s.equals("")) return 0;
        char[] chars = new char[60];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            chars[cs[i] - 65]++;

        }
        int dbl = 0;
        int single = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 == 0) {
                dbl += chars[i];
            } else {
                dbl += chars[i] - 1;
                single = 1;
            }
        }
        return dbl + single;
    }
}