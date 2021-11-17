package easy;

// https://leetcode-cn.com/problems/complement-of-base-10-integer/
// 1009. 十进制整数的反码
class lc1009 {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        return N ^ ((Integer.highestOneBit(N) << 1) - 1);
    }

    public int bitwiseComplement2(int n) {
        if (n == 0) {
            return 1;
        }
        int num = 31;
        while ((n >> num) != 1) {
            num--;
        }

        int mask = 0;
        for (int i = 0; i <= num; i++) {
            mask = (mask << 1) | 1;
        }
        return (~n) & mask;
    }
}