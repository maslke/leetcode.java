package easy;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        String o = "";
        if (num < 0) {
            o = "-";
        }
        num = Math.abs(num);
        String ret = "";
        while (num != 0) {
            ret = String.valueOf(num % 7) + ret;
            num = num / 7;
        }
        return o + ret;
    }
}
