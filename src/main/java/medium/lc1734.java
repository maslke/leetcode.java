package medium;

// https://leetcode-cn.com/problems/decode-xored-permutation/
// 1734. 解码异或后的排列
public class lc1734 {
    public int[] decode(int[] encoded) {
        int length = encoded.length;
        int[] ret = new int[length + 1];
        int a = 1;
        for (int i = 2; i <= length + 1; i++) {
            a = a ^ i;
        }
        int b = encoded[1];
        for (int i = 3; i < encoded.length; i = i + 2) {
            b = b ^ encoded[i];
        }

        ret[0] = a ^ b;
        for (int i = 1; i < ret.length; i++) {
            ret[i] = encoded[i - 1] ^ ret[i - 1];
        }
        return ret;
    }
}
