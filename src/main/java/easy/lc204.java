package easy;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 204. Count Primes
 * 素数筛选法
 */
public class lc204 {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] ret = new boolean[n];
        for (int i = 0; i < n; i++) {
            ret[i] = true;
        }
        ret[0] = false;
        ret[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (ret[i]) {
                for (int j = i + i; j < n; j = j + i) {
                    ret[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ret[i]) {
                count++;
            }
        }
        return count;
    }
}
