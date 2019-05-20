package easy;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 7. Reverse Integer
 */
public class lc7 {
    public int reverse(int x) {
        boolean positive;
        if (x < 0) {
            positive = false;
        } else {
            positive = true;
        }
        x = Math.abs(x);
        int ret = 0;
        while (x > 0) {
            int m = x % 10;
            if (positive) {
                if (ret > (Integer.MAX_VALUE - m) / 10) {
                    return 0;
                }
            } else {
                if (-1 * ret < (Integer.MIN_VALUE + m) / 10) {
                    return 0;
                }
            }
            ret = 10 * ret + m;
            x = x / 10;

        }
        if (positive) {
            return ret;
        } else {
            return -1 * ret;
        }
    }
}
