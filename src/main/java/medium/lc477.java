package medium;

// https://leetcode-cn.com/problems/total-hamming-distance/
// 477. 汉明距离总和

public class lc477 {
    public int totalHammingDistance(int[] nums) {
        int ret = 0;
        int n = nums.length;
        for (int i = 29; i >= 0; i--) {
            int one = 0;
            for (int j = 0; j < nums.length; j++) {
                one += (nums[j] >> i) & 1;

            }
            ret += one * (n - one);
        }
        return ret;
    }
}
