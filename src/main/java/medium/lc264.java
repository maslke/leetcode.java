package medium;

// https://leetcode-cn.com/problems/ugly-number-ii/
// 264. 丑数 II

public class lc264 {
    public int nthUglyNumber(int n) {
        int[] ret = new int[n + 1];
        int a1 = 1;
        int a2 = 1;
        int a3 = 1;
        ret[1] = 1;
        for (int i = 2; i <= n; i++) {
            int a = ret[a1] * 2;
            int b = ret[a2] * 3;
            int c = ret[a3] * 5;
            int m = Math.min(a, Math.min(b, c));
            if (m == a) {
                a1++;
            }
            if (m == b) {
                a2++;
            }
            if (m == c) {
                a3++;
            }
            ret[i] = m;

        }
        return ret[n];


    }
}
