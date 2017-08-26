package easy;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 171. Excel Sheet Column Number
 */
public class lc171 {
    public int titleToNumber(String s) {
        int len = s.length();
        int x = 0;
        int ret = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            ret = (int)Math.pow(26, x) * (c - 64) + ret;
            x++;
        }
        return ret;
    }
}
