package medium;

/**
 * https://leetcode-cn.com/problems/plates-between-candles/
 * 2055. 蜡烛之间的盘子
 */
public class lc2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] sum = new int[len];
        for (int i = 0, s1 = 0; i < len; i++) {
            if (chars[i] == '*') {
                s1++;
            }
            sum[i] = s1;
        }
        for (int i = 0, l = -1; i < len; i++) {
            if (chars[i] == '|') {
                l++;
            }
            left[i] = l;
        }
        for (int i = len - 1, r = -1; i >= 0; i--) {
            if (chars[i] == '|') {
                r++;
            }
            right[i] = r;
        }
        int[] ret = new int[len];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int x = left[q[1]];
            int y = right[q[0]];
            ret[i] = x == -1 || y == -1 || x >= y ? 0 : sum[y] - sum[x];
        }
        return ret;
    }
}
