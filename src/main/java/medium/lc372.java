package medium;

// https://leetcode-cn.com/problems/super-pow/
// 372. 超级次方
public class lc372 {
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    private int dfs(int a, int[] b, int end) {
        if (end == -1) {
            return 1;
        }
        return qpow(a, b[end]) * (qpow(dfs(a, b, end - 1), 10)) % 1337;
    }

    int qpow(int a, int b) {
        int ans = 1;
        for (int i = 1; i <= b; i++) {
            ans *= a % 1337;
            ans = ans % 1337;
        }
        return ans;
    }
}
