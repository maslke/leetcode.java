package hard;

// https://leetcode-cn.com/problems/frog-jump/
// 403. 青蛙过河

public class lc403 {

    public boolean canCross2(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k] || dp[j][k + 1] || dp[j][k - 1];

                if (i == 1 && dp[i][k]) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= i; k++) {

                int j = search(stones, i, k);
                if (j > -1) {
                    dp[i][k] = dp[j][k] || dp[j][k + 1] || dp[j][k - 1];
                }

                if (i == n - 1 && dp[i][k]) {
                    return true;
                }

            }
        }

        return false;

    }

    private int search(int[] stones, int i, int k) {
        int left = 0;
        int right = i - 1;
        int ret = -1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int m = stones[i] - stones[middle];
            if (m == k) {
                ret = middle;
                return ret;
            }
            else if (m > k) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return ret;
    }
}
