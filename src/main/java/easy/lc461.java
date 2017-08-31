package easy;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc461 {
    public int hammingDistance(int x, int y) {
        int m = x ^ y;
        String r = Integer.toBinaryString(m);
        int ret = 0;
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '1') {
                ret++;
            }
        }
        return ret;
    }
}
