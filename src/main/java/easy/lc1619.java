package easy;

// https://leetcode-cn.com/problems/mean-of-array-after-removing-some-elements/solution/

import java.util.Arrays;

public class lc1619 {
    public double trimMean(int[] arr) {

        Arrays.sort(arr);
        int count = (int)(arr.length * 0.05);

        int sum = 0;
        for (int i = count; i < arr.length - count; i++) {
            sum += arr[i];
        }
        return 1.0 * sum / (0.9 * arr.length);
    }
}
