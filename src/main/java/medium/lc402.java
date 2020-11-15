package medium;

// https://leetcode-cn.com/problems/remove-k-digits/
// 402. 移除K位数字
// Remember!!!

import java.util.Stack;

public class lc402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        boolean noZero = false;
        for (int i = 0; i < stack.size(); i++) {
            char c = stack.get(i);
            if (c != '0') {
                sb.append(c);
                noZero = true;
            } else if (noZero) {
                sb.append(c);
            }
        }


        String ret = sb.toString();
        return ret.equals("") ? "0" : ret;
    }
}
