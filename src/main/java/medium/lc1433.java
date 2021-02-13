package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/check-if-a-string-can-break-another-string/
// 1433. 检查一个字符串是否可以打破另一个字符串

public class lc1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] sa = s1.toCharArray();
        char[] sb = s2.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(sb);
        int i = 0;
        while (i < sa.length) {
            if (sa[i] != sb[i]) {
                break;
            }
            i++;
        }
        boolean relation = sa[i] > sb[i];
        for (int inx = i; inx < sa.length; inx++) {
            if (sa[inx] == sb[inx]) continue;
            if ((sa[inx] > sb[inx]) != relation) {
                return false;
            }
        }
        return true;
    }
}
