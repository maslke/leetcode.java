package medium;

// https://leetcode.com/problems/daily-temperatures/
// 739. Daily Temperatures

import java.util.Stack;

class lc739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : (stack.pop() - i);
            stack.push(i);
        }
        return result;
    }
}