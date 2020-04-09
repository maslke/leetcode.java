package medium;

// https://leetcode-cn.com/problems/string-to-integer-atoi/
// 8. 字符串转换整数(atoi)
class Solution {
    public int myAtoi(String str) {
        int ret = 0;
        boolean negative = false;
        str = str.trim();
        if (str.length() == 0) return 0;
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            negative = true;
            str = str.substring(1);
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!isNumberic(c)) break;
            int value = Integer.parseInt(String.valueOf(c));
            if ((Integer.MAX_VALUE - value) / 10 < ret) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } 
            ret = 10 * ret + value;
        }
        return negative ? -1 * ret : ret;
    }

    private boolean isNumberic(char c) {
        return c >= '0' && c <= '9';
    }
}