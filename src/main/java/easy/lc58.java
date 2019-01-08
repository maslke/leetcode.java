//https://leetcode.com/problems/length-of-last-word/
//58. Length of Last Word
/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 58. Length of Last Word
 */
public class lc58 {
    public int lengthOfLastWord(String s) {
        int len = 0;
        if (s == null || s.isEmpty()) {
            return 0;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (len != 0) {
                    break;
                }
            } else {
                len++;
            }

        }
        return len;
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = s.length() - 1;
        int start = -1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (start != -1) {
                    break;
                } else {
                    i--;
                }
            } else {
                if (start == -1) {
                    start = i;
                }
                i--;
            }
        }
        if (start == -1) return 0;
        return start - i;
    }
}
