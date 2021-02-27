package medium;

// https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
// 395. 至少有K个重复字符的最长子串

public class lc395 {
    public int longestSubstring(String s, int k) {
        return longest(s, 0, s.length() - 1, k);
    }

    private int longest2(String s, int left, int right, int k) {
        int[] frequency = new int[26];
        for (int i = left; i <= right; i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        int index = -1;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0 && frequency[i] < k) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return right - left + 1;
        }

        char chr = (char) (index + 'a');
        int ret = 0;
        int inx = left;
        while (inx <= right) {

            while (inx <= right && s.charAt(inx) == chr) {
                inx++;
            }
            if (inx > right) {
                break;
            }
            int l = inx;
            while (inx <= right && s.charAt(inx) != chr) {
                inx++;
            }
            ret = Math.max(ret, longest2(s, l, inx - 1, k));
        }

        return ret;

    }

    private int longest(String s, int left, int right, int k) {
        int[] frequency = new int[26];
        for (int i = left; i <= right; i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        int index = -1;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0 && frequency[i] < k) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return right - left + 1;
        }

        int split = -1;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) - 'a' == index) {
                split = i;
                break;
            }
        }

        return Math.max(longest(s, left, split - 1, k), longest(s, split + 1, right, k));
    }
}
