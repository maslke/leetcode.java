package easy;

// https://leetcode-cn.com/problems/valid-perfect-square/
// 367. 有效的完全平方数
public class lc367 {
    public boolean isPerfectSquare(int num) {
        int sqrt = (int) getSqrt(1.0, num);
        return sqrt * sqrt == num;
    }

    private double getSqrt(double guess, int num) {
        if (!good(guess, num)) {
            return getSqrt((guess + num / guess) / 2, num);
        }
        else {
            return guess;
        }
    }

    private boolean good(double guess, int num) {
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
        if (num < 2) {
            return true;
        }
        int left = 2;
        int right = num / 2;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (num / middle == middle && num % middle == 0) {
                return true;
            }
            else if (num / middle >= middle) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return false;
    }
}
