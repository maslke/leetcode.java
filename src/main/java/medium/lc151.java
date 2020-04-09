package medium;

// https://leetcode-cn.com/problems/reverse-words-in-a-string/
// 151. 翻转字符串里的单词

public class lc151 {
    public String reverse(String s) {
        if (s == null) return s;
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (s.charAt(i - 1) != ' ') {
                sb.append(c);
            }
        }

        s = sb.toString();
        char[] chars = s.toCharArray();
        reverse(chars);
        int i = 0;
        while (i < chars.length) {
            int m = i;
            while (chars[m] != ' ') {
                m++;
            }
            reverse(i, m - 1, chars);
        }
        return new String(chars);
    }

    private void reverse(int left, int right, char[] chars) {
        while (left < right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
    }

    private void reverse(char[] chars) {
        reverse(0, chars.length - 1, chars);
    }




}