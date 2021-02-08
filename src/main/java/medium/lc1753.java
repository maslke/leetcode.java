package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/maximum-score-from-removing-stones/
// 1753. 移除石子的最大得分

public class lc1753 {

    public int maximumScore2(int a, int b, int c) {
        if (a + b < c) return a + b;
        if (a + c < b) return a + c;
        if (b + c < a) return b + c;
        return (a + b + c) / 2;
    }

    public int maximumScore(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        int ret = 0;
        while (nums[1] > 0) {
            nums[2]--;
            nums[1]--;
            Arrays.sort(nums);
            ret++;
        }
        return ret;
    }
}
