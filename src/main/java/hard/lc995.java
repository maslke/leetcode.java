package hard;

// https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/
// 995. K连续位的最小翻转次数

public class lc995 {
    public int minKBitFlips(int[] A, int K) {
        int[] diff = new int[A.length + 1];
        int ret = 0;
        int reverseCount = 0;
        for (int i = 0; i < A.length; i++) {
            reverseCount += diff[i];
            if ((reverseCount + A[i]) % 2 == 0) {
                if (i + K > A.length) {
                    return -1;
                }
                reverseCount++;
                ret++;
                diff[i + K]--;
            }
        }
        return ret;
    }
}
