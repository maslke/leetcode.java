package easy;

// https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters/
// 1624. 两个相同字符之间的最长字符串

import java.util.Arrays;

public class lc1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int len = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (left[c - 'a'] == -1) {
                left[c - 'a'] = i;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (right[c - 'a'] == -1) {
                right[c - 'a'] = i;
            }
        }

        int res = -1;
        for (int i = 0; i < 26; i++) {
            if (left[i] != right[i]) {
                res = Math.max(res, right[i] - left[i] - 1);
            }
        }
        return res;
    }
}
