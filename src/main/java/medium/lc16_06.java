package medium;

// https://leetcode-cn.com/problems/smallest-difference-lcci/
// 面试题16.06. 最小差

import java.util.Arrays;

public class lc16_06 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        long min = (long) Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                long d = (long)a[i] - (long)b[j];
                if (min > d) {
                    min = d;
                }
                j++;
            } else if (a[i] < b[j]) {
                long d = (long)b[j] - (long)a[i];
                if (min > d) {
                    min = d;
                }
                i++;
            } else {
                return 0;
            }
        }
        return (int) min;
    }
}
