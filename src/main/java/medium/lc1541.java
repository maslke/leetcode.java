package medium;

// https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// 1541. 平衡括号字符串的最少插入次数

public class lc1541 {
    public int minInsertions(String s) {
        int left = 0;
        int right = 0;
        int len = s.length();
        int count = 0;
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
                i++;
            } else {
                if (i == len - 1 || s.charAt(i + 1) != ')') {
                    if (left == 0) {
                        count = count + 2;
                    } else {
                        count = count + 1;
                        left--;
                    }
                    i = i + 1;
                } else {
                    if (s.charAt(i + 1) == ')') {
                        if (left == 0) {
                            count++;
                        } else {
                            left--;
                        }
                        i = i + 2;
                    }
                }
            }
        }
        return count + 2 * left;
    }
}
