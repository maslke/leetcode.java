package easy;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 367. Valid Perfect Square
 */
public class lc367 {
    public boolean isPerfectSquare(int num) {
        int sqrt = getSqrt(1.0, num);
        return sqrt * sqrt == num;
    }

    private int getSqrt(double guess, int num) {
        if (!good(guess, num)) {
            return getSqrt((guess + num / guess ) /2 ,num);
        } else {
            return (int)guess;
        }
    }

    private boolean good (double guess, int num) {
        return Math.abs(guess * guess - num) <= 0.001;
    }
}
