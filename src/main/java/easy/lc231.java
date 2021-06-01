package easy;

// https://leetcode-cn.com/problems/power-of-two/
// 231. 2的幂
public class lc231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
