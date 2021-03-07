package medium;

// https://leetcode-cn.com/problems/longest-palindromic-substring/
// 5.最长回文子串

import java.util.Arrays;

public class lc5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }

        boolean[][] valid = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(valid[i], true);
        }
        int a = 0;
        int b = 0;
        int ret = 1;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                valid[i][j] = (s.charAt(i) == s.charAt(j)) && valid[i + 1][j - 1];
                if (valid[i][j]) {
                    if (ret < j - i + 1) {
                        ret = j - i + 1;
                        a = i;
                        b = j;
                    }
                }
            }
        }
        return s.substring(a, b + 1);
    }
}
