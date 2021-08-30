package medium;

import java.util.Random;

// https://leetcode-cn.com/problems/random-pick-with-weight/
// 528. 按权重随机选择
public class lc528 {
    private int sum;
    private int[] weights;
    private int[] w;
    private Random random;

    public lc528(int[] w) {
        sum = 0;
        this.w = w;
        weights = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                weights[i] = w[i];
            }
            else {
                weights[i] = (w[i] + weights[i - 1]);
            }
        }
        sum = weights[w.length - 1];
        random = new Random();
    }

    public int pickIndex() {
        int value = random.nextInt(sum);
        // for (int i = 0; i < weights.length; i++) {
        //     value -= w[i];
        //     if (value < 0) {
        //         return i;
        //     }
        // }
        // return -1;
        return bs(weights, value);
    }

    // find first value > target
    private int bs(int[] weights, int target) {
        int left = 0;
        int right = weights.length - 1;
        int ret = 0;
        while (left <= right) {
            int m = (right - left) / 2 + left;
            int v = weights[m];
            if (v == target) {
                left = m + 1;
            }
            else if (v < target) {
                left = m + 1;
            }
            else {
                ret = m;
                right = m - 1;
            }
        }
        return ret;
    }
}
