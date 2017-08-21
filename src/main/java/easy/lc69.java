package easy;

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 69. Sqrt(x)
 */
public class lc69 {
    public int mySqrt(int x) {
        return (int)sqrt(1.0, x);
    }

    private boolean good(double guess, int x) {
        return guess * guess - x < 0.1 && guess * guess - x > -0.1;
    }

    private double sqrt(double begin, int x) {
        if (good(begin ,x)) {
            return begin;
        } else {
            return sqrt(( begin + x / begin) / 2, x);
        }
    }
}
