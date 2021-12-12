package easy;

// https://leetcode-cn.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
// 1941. 检查是否所有字符出现次数相同
public class lc1941 {
    public boolean areOccurrencesEqual(String s) {
        int[] times = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            times[c - 'a']++;
        }
        Integer a = null;
        for (int i = 0; i < 26; i++) {
            if (times[i] > 0) {
                if (a == null) {
                    a = times[i];
                } else if (a != times[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
