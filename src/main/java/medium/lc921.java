package medium;

// https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
// 921. 使括号有效的最小添加

public class lc921 {
    public int minAddToMakeValid(String S) {
        int ret = 0;
        int i = 0;
        int count = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    ret++;
                } else {
                    if (count >= 1) {
                        count--;
                    } else {
                        ret++;
                    }
                }
            }
            i++;
        }
        return ret + count;
    }
}
