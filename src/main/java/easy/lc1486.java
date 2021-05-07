package easy;

// https://leetcode-cn.com/problems/xor-operation-in-an-array/
// 1486. 数组异或操作
// ????
// 2022/5/7 现在不迷惑了，看了别人的O(1)解法。

public class lc1486 {
    public int xorOperation(int n, int start) {
        int last = n & start & 1;
        int s = start / 2;
        int m = xor(s - 1) ^ xor(s + n - 1);
        return (m << 1) + last;
    }

    private int xor(int s) {
        int m = s % 4;
        switch(m) {
            case 0:
                return s;
            case 1:
                return 1;
            case 2:
                return s + 1;
            default:
                return 0;
        }
        // return -1;
    }
}
