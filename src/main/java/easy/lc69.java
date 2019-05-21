package easy;

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 69. Sqrt(x)
 */
//牛顿迭代法求解平方根
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

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int begin = 1;
        int end = Integer.MAX_VALUE;
        int m = 0;
        while (true) {
            m = (end - begin) / 2 + begin;
            if (m > x / m) {
                end = m - 1;
            } else {
                if ((m + 1) > x / (m + 1)) {
break;
                }
                begin = m + 1;
            }
            
        }
        return m;
    }
}

