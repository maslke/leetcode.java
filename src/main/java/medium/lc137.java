package medium;

// https://leetcode-cn.com/problems/single-number-ii/
// 137. 只出现一次的数字 II

public class lc137 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int a = 0;
            for (int n : nums) {
                a += (1 & (n >> i));
            }

            if (a % 3 != 0) {
                ret = (1 << i) | ret;
            }
        }
        return ret;
    }
}
