package medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

// https://leetcode-cn.com/problems/next-greater-element-iii/
// 556. 下一个更大元素 III

public class lc556 {
    public int nextGreaterElement(int n) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            int v = n % 10;
            n = n / 10;
            if (!stack.isEmpty() && stack.peek() > v) {
                LinkedList<Integer> list = new LinkedList<>();
                while (!stack.isEmpty() && stack.peek() > v) {
                    list.offerLast(stack.pop());
                }
                int m = list.pollLast();
                list.offerLast(v);
                while (!stack.isEmpty()) {
                    list.offerLast(stack.pop());
                }

                list.sort((a, b) -> {
                    return b - a;
                });

                list.offerLast(m);

                while (n > 0) {
                    list.add(n % 10);
                    n = n / 10;
                }
                int plus = 1;

                for (int i = 0; i < list.size(); i++) {
                    if ((Integer.MAX_VALUE - ret) / plus < list.get(i)) {
                        return -1;
                    }
                    ret = ret + list.get(i) * plus;
                    plus = plus * 10;
                }

                return ret;

            }

            stack.push(v);
        }
        ret = -1;
        return ret;
    }
}
