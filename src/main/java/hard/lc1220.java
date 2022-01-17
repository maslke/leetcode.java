package hard;

// https://leetcode-cn.com/problems/count-vowels-permutation/
// 1220. 统计元音字母序列的数目
public class lc1220 {
    public int countVowelPermutation(int n) {
        // a  -> e,i,u,
        // e -> a,i,
        // i -> e,o,
        // o -> i,
        // u -> i,o,
        long MOD = 1000000007;

        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;

        for (int inx = 2; inx <= n; inx++) {
            long a1 = (e + i + u) % MOD;
            long e1 = (a + i) % MOD;
            long i1 = (e + o) % MOD;
            long o1 = i % MOD;
            long u1 = (i + o) % MOD;
            a = a1;
            e = e1;
            i = i1;
            o = o1;
            u = u1;
        }
        return (int) ((a + e + i + o + u) % MOD);
    }
}
