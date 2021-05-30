package easy;

// https://leetcode-cn.com/problems/power-of-four/
// 342. 4的幂次方

public class lc342 {
    public boolean isPowerOfFour(int n) {
        int v = 0b01010101010101010101010101010101;
        return n > 0 && ((n & (n - 1)) == 0) && ((n | v) == v);
    }
}
