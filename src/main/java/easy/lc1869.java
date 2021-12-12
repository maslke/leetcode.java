package easy;

// https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros/
// 1869. 哪种连续子字符串更长
public class lc1869 {
    public boolean checkZeroOnes(String s) {
        int maxLength0 = 0, maxLength1 = 0;
        int i = 0;
        int len = s.length();
        while (i < len) {
            int j = i;
            while (j < len && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int max = j - i;
            if (s.charAt(i) == '0') {
                maxLength0 = Math.max(maxLength0, max);
            } else {
                maxLength1 = Math.max(maxLength1, max);
            }
            i = j;
        }
        return maxLength1 > maxLength0;
    }
}
