package medium;

// https://leetcode-cn.com/problems/reorganize-string/
// 767. 重构字符串

public class lc767 {
    public String reorganizeString(String s) {
        int length = s.length();
        char[] ret = new char[length];
        int[] count = new int[26];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        int max = 0;
        int maxIndex = 0;
        int threshold = (length + 1) / 2;
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                maxIndex = i;
            }
            if (max > threshold) {
                return "";
            }
        }
        int inx = 0;
        while (count[maxIndex] > 0) {
            ret[inx] = (char) (maxIndex + 'a');
            count[maxIndex]--;
            inx += 2;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (inx >= ret.length) {
                    inx = 1;
                }
                ret[inx] = (char) (i + 'a');
                count[i]--;
                inx += 2;
            }
        }

        return new String(ret);
    }
}
