package easy;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 367. Valid Perfect Square
 */
public class lc367 {
    public boolean isPerfectSquare(int num) {
        int sqrt = (int)getSqrt(1.0, num);
        return sqrt * sqrt == num;
    }

    private double getSqrt(double guess, int num) {
        if (!good(guess, num)) {
            return getSqrt((guess + num / guess ) /2 ,num);
        } else {
            return guess;
        }
    }

    private boolean good (double guess, int num) {
        return Math.abs(guess * guess - num) <= 0.00001;
    }


    // 4 = 1 + 3
    // 9 = 1 + 3 + 5
    // 16 = 1 + 3 + 5 + 7
    // 25 = 16 + 9
    public boolean isPerfectSquare2(int num) {
        int index = 1;
        while (num > 0) {
            num -= index;
            index += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare3(int num) {
        if (num <= 1) return true;
        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            long v = middle * middle;
            if (v == num) return true;
            if (v < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
