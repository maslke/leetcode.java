package easy;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 * 374. Guess Number Higher or Lower
 */
public class lc374 {
    public int guessNumber(int n) {
        return guess(1, n, n);
    }

    private int guess(int left, int right, int n) {
        int mid = left + (right - left) / 2;
        int val = guess(mid);
        if (val == 0) {
            return mid;
        } else if (val < 0) {
            return guess(left, mid - 1, n);
        } else {
            return guess(mid + 1, right, n);
        }
    }

    private int guess(int n) {
        // return 1 or -1 or 0;
        return 1;
    }
}
