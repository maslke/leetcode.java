package hard;

// https://leetcode-cn.com/problems/patching-array/
// 330. 按要求补齐数组
// 不会做

public class lc330 {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int inx = 0;
        long x = 1;
        while (x <= n) {
            if (inx < nums.length && nums[inx] <= x) {
                x += nums[inx++];
            } else {
                count++;
                x = x * 2;
            }
        }
        return count;
    }
}
