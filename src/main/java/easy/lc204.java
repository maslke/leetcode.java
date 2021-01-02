package easy;

import java.util.Arrays;

// https://leetcode-cn.com/problems/count-primes/
// 204. 计数质数

public class lc204 {

    public int countPrimes2(int n) {
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flags[i]) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j = j + i) {
                        flags[j] = false;
                    }
                }
            }
        }

        return count;
    }


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
