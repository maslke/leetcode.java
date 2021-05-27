package easy;

// https://leetcode-cn.com/problems/hamming-distance/
// 461. 汉明距离

public class lc461 {
    public int hammingDistance(int x, int y) {
        int c = x ^ y;
        int ret = 0;
        for (int i = 31; i >= 0; i--) {
            ret += (c >> i) & 1;
        }
        return ret;
    }
}
