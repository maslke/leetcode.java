package easy;

import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/9/24
 * Version:0.0.1
 * 682. Baseball Game
 */
public class lc682 {
    public int calPoints(String[] ops) {
        Stack<String> stack = new Stack<String>();
        int v1, v2;
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("+")) {
                v1 = Integer.valueOf(stack.pop());
                v2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(v2));
                stack.push(String.valueOf(v1));
                stack.push(String.valueOf(v1 + v2));
            } else if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                v1 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(v1));
                stack.push(String.valueOf(2 * v1));
            } else {
                stack.push(s);
            }
        }
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += Integer.valueOf(stack.pop());
        }
        return ret;
    }
}
