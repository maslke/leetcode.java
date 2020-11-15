package easy;

// https://leetcode-cn.com/problems/xor-operation-in-an-array/
// 1486. 数组异或操作
// ????

public class lc1486 {
    public int xorOperation(int n, int start) {
        int i = 1;
        int ret = start;
        while (i < n) {
            ret = ret ^ (start + 2 * i);
            i++;
        }
        return ret;
    }
}
