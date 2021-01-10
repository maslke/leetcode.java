package easy;

// https://leetcode-cn.com/problems/decode-xored-array/
// 5649. 解码异或后的数组

public class lc5649 {
    public int[] decode(int[] encoded, int first) {
        int[] ret = new int[encoded.length + 1];
        ret[0] = first;
        for (int i = 1; i < ret.length; i++) {
            ret[i] = first ^ encoded[i - 1];
            first = ret[i];
        }
        return ret;
    }
}
