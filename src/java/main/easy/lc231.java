package main.easy;

/**
 * Author:maslke
 * Date:2017/8/17
 * Version:0.0.1
 * 231. Power of Two
 */
public class lc231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        return n % 2 == 0 && isPowerOfTwo(n / 2);
    }
}
