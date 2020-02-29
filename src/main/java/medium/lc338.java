package medium;

// https://leetcode.com/problems/counting-bits/
// 338. Counting Bits
class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        if (num == 0) {
            ret[0] = 0;
            return ret;
        }
        ret[0] = 0;
        ret[1] = 1;
        int n = 1;
        for (int i = 2; i <= num; i++) {
            if (i - n == n) {
                ret[i] = 1;
                n = i;
            } else {
                ret[i] = ret[i - n] + ret[n];
            }
        }
        return ret;
    }
}