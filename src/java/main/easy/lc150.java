package main.easy;

import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/18
 * Version:0.0.1
 * 150. Evaluate Reverse Polish Notation
 */
public class lc150 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        String o;
        int first, second;
        for (int i = 0; i < tokens.length; i++) {
            o = tokens[i];
            int inx = "+-*/".indexOf(o);
            if (inx >= 0) {
                first = Integer.valueOf(stack.pop());
                second = Integer.valueOf(stack.pop());
                if (inx == 0) {
                    stack.push(String.valueOf(first + second));
                } else if (inx == 1) {
                    stack.push(String.valueOf(second - first));
                } else if (inx == 2) {
                    stack.push(String.valueOf(first * second));
                } else if (inx == 3) {
                    stack.push(String.valueOf(second / first));
                }
            } else {
                stack.push(o);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
