package easy;

// https://leetcode-cn.com/problems/thousand-separator/
// 1556. 千位分隔数

public class lc1556 {
    public String thousandSeparator(int n) {
        String t = String.valueOf(n);
        int len = t.length();
        if (len <= 3) {
            return t;
        }
        int count = (len - 1) / 3;
        char[] chars = new char[len + count];
        int i = len - 1;
        int inx = chars.length - 1;
        count = 0;
        while (i >= 0) {
            char c = t.charAt(i);
            if (count != 0 && count % 3 == 0) {
                chars[inx--] = '.';
            }
            chars[inx--] = c;
            count++;
            i--;
        }

        return new String(chars);


    }
}
