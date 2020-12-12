package easy;

// https://leetcode-cn.com/problems/arranging-coins/
// 441. 排列硬币

public class lc441 {
    public int arrangeCoins(int n) {
        long left = 1;
        long right = n;
        while (left <= right) {
            long middle = (right - left) / 2 + left;
            long count = middle * (middle + 1) / 2;
            if (count > n) {
                right = middle - 1;
            } else if (count == n) {
                return (int) middle;
            } else {
                left = middle + 1;
            }
        }
        return (int) right;


    }
}
