package medium;

// https://leetcode-cn.com/problems/super-ugly-number/
// 313. 超级丑数

import java.util.Arrays;

public class lc313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);

        for (int i = 2; i <= n; i++) {

            int v = Integer.MAX_VALUE;
            int[] nums = new int[primes.length];
            for (int j = 0; j < primes.length; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                v = Math.min(v, nums[j]);
            }
            dp[i] = v;
            for (int j = 0; j < primes.length; j++) {
                if (nums[j] == dp[i]) {
                    pointers[j]++;
                }
            }
        }


        return dp[n];
    }
}
