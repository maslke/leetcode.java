package medium;

// https://leetcode-cn.com/problems/delete-and-earn/
// 740. 删除并获得点数

public class lc740 {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] values = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            values[nums[i]] += nums[i];
        }

        return value(values);
    }

    private int value(int[] nums) {
        int first = nums[0];
        int second = Math.max(first, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int v = Math.max(first + nums[i], second);
            first = second;
            second = v;
        }
        return second;
    }
}
