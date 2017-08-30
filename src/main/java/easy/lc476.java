package easy;

/**
 * Author:maslke
 * Date:2017/8/30
 * Version:0.0.1
 */
public class lc476 {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        int ret = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') {
                ret = ret + (int)Math.pow(2, length - i - 1);
            }
        }
        return ret;
    }
}
