package easy;

// https://leetcode-cn.com/problems/increasing-decreasing-string/
// 1370. 上升下降字符串

public class lc1370 {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        while (true) {
            boolean visited = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 0) {
                    visited = true;
                    sb.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] > 0) {
                    visited = true;
                    sb.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
            if (!visited) {
                break;
            }
        }
        return sb.toString();
    }
}
