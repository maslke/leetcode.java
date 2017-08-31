package hard;

import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc224 {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int ret = 0;
        int length = s.length();
        Stack<String> stack = new Stack<String>();
        int i = 0;
        while (i < length) {
            String c = s.substring(i, i + 1);
            if (c.equals(" ")) {
                i++;
                continue;
            }
            if (c.equals("(")) {
                i++;
                stack.push(c);
            } else if (c.equals(")")) {
                i++;
                int v1 = Integer.valueOf(stack.pop());
                stack.pop();
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    stack.push(String.valueOf(v1));
                } else {
                    String o = stack.pop();
                    int v2 = Integer.valueOf(stack.pop());
                    if (o.equals("+")) {
                        stack.push(String.valueOf(v1 + v2));
                    } else {
                        stack.push(String.valueOf(v2 - v1));
                    }
                }
            } else if (c.equals("+") || c.equals("-")) {
                i++;
                stack.push(c);
            } else {
                int m = i;
                for (; m < length; m++) {
                    if (!s.substring(m, m + 1).matches("\\d")) {
                        break;
                    }
                }
                String op = s.substring(i, m);
                i = m;
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    stack.push(op);
                } else {
                    int v1 = Integer.valueOf(op);
                    String o = stack.pop();
                    int v2 = Integer.valueOf(stack.pop());
                    if (o.equals("+")) {
                        stack.push(String.valueOf(v1 + v2));
                    } else {
                        stack.push(String.valueOf(v2 - v1));
                    }
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
