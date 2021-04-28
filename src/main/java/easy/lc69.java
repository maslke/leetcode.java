package easy;

// https://leetcode-cn.com/problems/sqrtx/
// 69. x的平方根
public class lc69 {
    public int mySqrt(int x) {
        return (int) sqrt(1.0, x);
    }

    private boolean good(double guess, int x) {
        return guess * guess - x < 0.1 && guess * guess - x > -0.1;
    }

    private double sqrt(double begin, int x) {
        if (good(begin, x)) {
            return begin;
        }
        else {
            return sqrt((begin + x / begin) / 2, x);
        }
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        int left = 2;
        int right = x / 2;
        int ret = 0;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (x / middle >= middle) {
                ret = middle;
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return ret;
    }
}

