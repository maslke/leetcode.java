package medium;

// https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
// 581. 最短无序连续子数组

import java.util.Stack;

public class lc581 {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        if (left == nums.length) {
            return 0;
        }
        int right = -1;
        stack.clear();
        for (int i = nums.length - 1; i>= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }

        return right - left + 1;
    }
}
