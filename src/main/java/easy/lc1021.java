package easy;

import java.util.Stack;

// https://leetcode-cn.com/problems/remove-outermost-parentheses/
// 1021. 删除最外层的括号

public class lc1021 {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int begin = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(S, begin + 1, i);
                    begin = i + 1;
                }
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses2(String S) {
        int level = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < S.length()) {
            char c = S.charAt(i);

            if (c == ')') {
                level--;
            }

            if (level >= 1) {
                sb.append(c);
            }

            if (c == '(') {
                level++;
            }
            i++;

        }
        return sb.toString();
    }
}
