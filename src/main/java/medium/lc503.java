package medium;

// https://leetcode-cn.com/problems/next-greater-element-ii/
// 下一个更大元素 II

import java.util.Arrays;
import java.util.Stack;

public class lc503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] ret = new int[nums.length];
        int n = nums.length;
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.peek()] = nums[i % n];
                stack.pop();
            }
            stack.push(i % n);
        }
        return ret;
    }
}
