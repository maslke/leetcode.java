package easy;

/**
 * Author:maslke
 * Date:2017/9/6
 * Version:0.0.1
 * 190. Reverse Bits
 */
public class lc190 {
    // you need treat n as an unsigned value
    //位运算的题目不要总是想着加减乘除
    public int reverseBits(int n) {
        int ret = 0;
        int index = 0;
        while (n != 0) {
            ret = (ret << 1)  | (n & 1);
            index++;
            n = n >>> 1;
        }
        for (int i = 0; i < 32 - index; i++) {
            ret = ret << 1;
        }
        return ret;
    }
}
