package medium;

//https://leetcode-cn.com/problems/counting-bits/
// 338. 比特位计数

public class lc338 {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        if (num == 0) {
            return ret;
        }

        ret[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0) {
                ret[i] = ret[i / 2];
            }
            else {
                ret[i] = ret[i - 1] + 1;
            }
        }
        return ret;
    }
}