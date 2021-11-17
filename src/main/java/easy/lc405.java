package easy;

// https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
// 405. 数字转换为十六进制数

public class lc405 {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        String p = "0123456789abcdef";
        for (int i = 7; i >= 0; i--) {
            int inx = (num >> (4 * i)) & 15;
            if (inx != 0 || sb.length() > 0) {
                sb.append(p.charAt(inx));
            }
        }

        return sb.toString();

    }
}
