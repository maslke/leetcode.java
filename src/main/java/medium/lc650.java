package medium;

// https://leetcode-cn.com/problems/2-keys-keyboard/
// 650. 只有两个键的键盘

public class lc650 {
    public int minSteps(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = 1001;

            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }

            }
        }
        return f[n];
    }
}
