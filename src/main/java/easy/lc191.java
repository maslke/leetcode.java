package easy;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 191. Number of 1 Bits
 * java的有符号右移和无符号右移
 */
public class lc191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
