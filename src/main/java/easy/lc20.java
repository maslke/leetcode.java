package easy;

import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 20. Valid Parentheses
 */
public class lc20 {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || (c == ')' && !stack.pop().equals('(')) || (c == ']' && !stack.pop().equals('['))
                        || (c == '}' && !stack.pop().equals('{'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
