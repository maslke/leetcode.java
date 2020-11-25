package easy;

import java.util.Stack;

// https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
// 1614. 括号的最大嵌套深度

public class lc1614 {
    public int maxDepth(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];
            if (ch == '(') {
                stack.push(ch);
                max = Math.max(max, stack.size());
            } else if (ch == ')') {
                stack.pop();
            }
            i++;
        }
        return max;
    }
}
