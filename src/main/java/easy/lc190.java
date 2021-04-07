package easy;


// https://leetcode-cn.com/problems/reverse-bits/
// 190. 颠倒二进位制

public class lc190 {
    public int reverseBits(int n) {
        int x = 31;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int m = n & 1;
            ret += m << x;
            x--;
            n = n >> 1;
        }
        return ret;
    }
}
