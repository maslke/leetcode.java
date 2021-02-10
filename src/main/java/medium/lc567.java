package medium;

import java.util.Arrays;// https://leetcode-cn.com/problems/permutation-in-string/
// 567. 字符串的排列

public class lc567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }
        int right = s1.length();
        int left = 0;
        int len = s2.length();
        int[] freq2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freq1, freq2)) return true;
        while (right < len) {
            freq2[s2.charAt(right) - 'a']++;
            freq2[s2.charAt(left) - 'a']--;
            if (Arrays.equals(freq1, freq2)) return true;
            right++;
            left++;
        }
        return false;
    }
}
