package medium;

// https://leetcode-cn.com/problems/house-robber-ii/
// 213. 打家劫舍 II

public class lc213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] choices = new int[2 * n - 2];
        choices[0] = nums[0];
        choices[1] = Math.max(nums[0], nums[1]);
        int inx = 2;
        int max = Math.max(choices[0], choices[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            choices[inx++] = Math.max(choices[i - 1], choices[i - 2] + nums[i]);
            max = Math.max(choices[inx - 1], max);
        }


        choices[inx++] = nums[1];
        choices[inx++] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            choices[inx] = Math.max(choices[inx - 1], choices[inx - 2] + nums[i]);
            max = Math.max(choices[inx], max);
            inx++;
        }
        return max;
    }
}
