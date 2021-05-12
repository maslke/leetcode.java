package medium;

// https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
// 1482. 制作 m 束花所需的最少天数
public class lc1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int length = bloomDay.length;
        if (length < m * k) {
            return -1;
        }
        int left = 1;
        int right = 1;
        for (int j : bloomDay) {
            right = Math.max(right, j);
        }

        while (left < right) {
            int middle = (right - left) / 2 + left;
            if (canMake(bloomDay, m, k, middle)) {
                right = middle;
            }
            else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int times = 0;
        for (int i = 0; i < bloomDay.length && count < m; i++) {
            if (bloomDay[i] <= day) {
                times++;
                if (times == k) {
                    count++;
                    times = 0;
                }
            }
            else {
                times = 0;
            }
        }

        return count >= m;
    }
}
