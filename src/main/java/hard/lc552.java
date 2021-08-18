package hard;

// https://leetcode-cn.com/problems/student-attendance-record-ii/
// 552. 学生出勤记录
public class lc552 {
    public int checkRecord(int n) {
        int mod = 1000000007;
        long a = 0;
        long b = 0;
        long c = 0;
        long d = 1;
        long e = 1;
        long f = 1;
        long g = 0;

        for (int i = 2; i <= n; i++) {
            long a1 = (a + b + c + d) % mod;
            long b1 = (a + d) % mod;
            long c1 = b % mod;
            long d1 = (e + f + g) % mod;
            long e1 = (e + f + g) % mod;
            long f1 = e;
            long g1 = f;

            a = a1;
            b = b1;
            c = c1;
            d = d1;
            e = e1;
            f = f1;
            g = g1;
        }

        return (int) ((a + b + c + d + e + f + g) % mod);
    }
}
