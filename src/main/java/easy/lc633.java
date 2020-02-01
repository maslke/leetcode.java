package easy;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 633. Sum of Square Numbers
 */
public class lc633 {
    public boolean judgeSquareSum(int c) {
        int sqrt = (int)Math.sqrt(c);
        if (sqrt * sqrt == c) {
            return true;
        }
        for (int i = 1; i <= sqrt; i++) {
            int v1 = i;
            int v2 = (int)Math.sqrt(c - v1 * v1);
            if (v2 * v2 == c - v1 * v1) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int low = 0;
        int high = (int)Math.sqrt(c);
        while (low <= high) {
            int v = low * low + high * high;
            if (v == c) {
                return true;
            } else if (v < c) {
                low = low + 1;
            } else {
                high = high - 1;
            }
        }
        return false;
    }
}
