package medium;

// https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
// 1456. 定长子串中元音的最大数目

public class lc1456 {
    public int maxVowels(String s, int k) {
        int max = 0;

        int len = s.length();
        int count = 0;

        int i = 0;
        while (i < len && i < k) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'u' || c == 'i' || c == 'o') {
                count++;
            }
            i++;
        }
        max = count;
        int j = 0;
        for (i = k; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'u' || c == 'i' || c == 'o') {
                count++;
            }
            c = s.charAt(j++);
            if (c == 'a' || c == 'e' || c == 'u' || c == 'i' || c == 'o') {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
