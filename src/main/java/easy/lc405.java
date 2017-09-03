package easy;

/**
 * Author:maslke
 * Date:2017/9/3
 * Version:0.0.1
 * 405. Convert a Number to Hexadecimal
 */
public class lc405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String x = Integer.toBinaryString(num);
        int length = x.length();
        for (int i = 0; i < 32 - length; i++) {
            x = "0" + x;
        }
        char[] chars = x.toCharArray();
        String ret = "";
        for (int i = 0; i < 8; i++) {
            int val = 8 * (chars[4 * i] - 48) + 4 * (chars[4 * i + 1] - 48) + 2 * (chars[4 * i + 2] - 48) + chars[4 * i + 3] - 48;
            if (val == 0 && ret.equals("")) {
                continue;
            }
            if (val >= 10) {
                ret = ret + Character.toString((char) (97 + val - 10));
            } else {
                ret = ret + val;
            }
        }
        return ret;
    }


}
