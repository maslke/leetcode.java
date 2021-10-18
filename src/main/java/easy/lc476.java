package easy;

// https://leetcode-cn.com/problems/number-complement/
// 476. 数字的补数

public class lc476 {
    public int findComplement(int num) {
        int n = 31;
        while (n >= 0) {
            if (((num >> n) & 1) == 1) {
                break;
            }
            n--;
        }

        int mask = 0;
        for (int i = 0; i <= n; i++) {
            mask = (mask << 1) | 1;
        }
        return (~num) & mask;
    }
}
