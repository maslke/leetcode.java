package medium;

import java.util.Stack;

// https://leetcode-cn.com/problems/132-pattern/
// 456. 132模式
public class lc456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        stack.push(nums[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < max) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max = Math.max(max, stack.pop());
            }

            stack.push(nums[i]);

        }
        return false;
    }
}
