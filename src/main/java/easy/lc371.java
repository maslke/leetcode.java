package easy;

/**
 * Author:maslke
 * Date:2017/9/1
 * Version:0.0.1
 * 371. Sum of Two Integers
 */
public class lc371 {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
