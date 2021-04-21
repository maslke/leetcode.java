package medium;

// https://leetcode-cn.com/problems/decode-ways/
// 91. 解码方法
public class lc91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        int[] f = new int[length + 1];
        f[0] = 1;

        for (int i = 1; i <= length; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && (s.charAt(i - 1) - '0' <= 6)))) {
                f[i] += f[i - 2];
            }
        }
        return f[length];
    }

    public int decodings(String s) {
        assert s.length() >= 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n];
        f[0] = 1;
        if (n <= 1) {
            return 1;
        }
        int first = s.charAt(0) - '0';
        int second = s.charAt(1) - '0';

        if (second != 0) {
            f[1] = 1;
        }
        if (first * 10 + second <= 26) {
            f[1] += 1;
        }

        for (int i = 2; i < n; i++) {
            if (s.charAt(i) != '0') {
                f[i] = f[i - 1];
            }

            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) - '0' <= 6)) {
                f[i] += f[i - 2];
            }
        }
        return f[n - 1];
    }
}
