package medium;

// https://leetcode-cn.com/problems/longest-repeating-character-replacement/
// 424. 替换后的最长重复字符

public class lc424 {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int len = s.length();
        int[] val = new int[26];
        int max = 0;
        while (right < len) {
            val[s.charAt(right) - 'A']++;
            max = Math.max(max, val[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                val[s.charAt(left) - 'A']--;
                left++;
            }
            right++;

        }
        return right - left;
    }
}
