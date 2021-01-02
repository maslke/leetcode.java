package medium;

// https://leetcode.com/problems/daily-temperatures/
// 739. Daily Temperatures

import java.util.ArrayDeque;
import java.util.Deque;

class lc739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peekLast()] <= T[i]) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                ret[i] = stack.peekLast() - i;
            }
            stack.offerLast(i);
        }
        return ret;
    }
}