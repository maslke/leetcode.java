package medium;
// https://leetcode-cn.com/problems/clumsy-factorial/
// 1006. 笨阶乘

public class lc1006 {
    public int clumsy(int N) {
        int ret = 0;
        int factor = 1;
        boolean flag = true;
        while (true) {
            if (N <= 0) {
                break;
            }
            if (flag) {
                int m = 0;
                if (N >= 3) {
                    m = N * (N - 1) / (N - 2);
                    N = N - 3;
                }
                else if (N >= 2) {
                    m = N * (N - 1);
                    N = N - 2;
                }
                else {
                    m = N;
                    N = N - 1;
                }
                if (ret == 0) {
                    ret = m;
                }
                else {
                    ret += m * factor;
                    factor *= -1;
                }
            }
            else {
                ret += N * factor;
                factor *= -1;
                N--;
            }
            flag = !flag;
        }
        return ret;
    }
}
