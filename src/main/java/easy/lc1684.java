package easy;

// https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/
// 1684. 统计一致字符串的数目

public class lc1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        int[] times = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            times[allowed.charAt(i) - 'a'] = 1;
        }
        for (String word : words) {
            int i = 0;
            while (i < word.length()) {
                if (times[word.charAt(i) - 'a'] == 0) {
                    break;
                }
                i++;
            }
            if (i == word.length()) {
                count++;
            }
        }
        return count;
    }
}
