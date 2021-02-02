package medium;

import java.util.Stack;

// https://leetcode-cn.com/problems/mini-parser/
// 385. 迷你语法分析器

public class lc385 {
    class NestedInteger {
        NestedInteger(int x) {

        }

        NestedInteger() {

        }

        void add(NestedInteger ni) {

        }

    }

    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int i = 0;
        int j = s.length();
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int positive = 1;
        while (i < j - 1) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                if (!stack.isEmpty()) {
                    stack.peek().add(nestedInteger);
                }
                stack.push(nestedInteger);
                i = i + 1;
            } else if (c == ']') {
                stack.pop();
                i = i + 1;
            } else if (c == ',') {
                i = i + 1;
            } else if (c == '-') {
                positive = -1;
                i = i + 1;
            } else {
                int m = i;
                int val = 0;
                while (m < j && s.charAt(m) >= '0' && s.charAt(m) <= '9') {
                    val = val * 10 + (s.charAt(m) - '0');
                    m++;
                }
                NestedInteger nestedInteger = new NestedInteger(positive * val);
                positive = 1;
                stack.peek().add(nestedInteger);
                i = m;
            }
        }
        return stack.peek();
    }
}
