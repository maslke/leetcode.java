package medium;

import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/9/17
 * Version:0.0.1
 * 227. Basic Calculator II
 */
public class lc227 {
    public int calculate(String s) {
        int len = s.length();
        int i = 0;
        Stack<String> stack = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        while (i < len) {
            String v = s.substring(i, i + 1);
            if (v.equals(" ")) {
                i++;
            } else if (v.equals("+") || v.equals("-")) {
                stack.push(v);
                i++;
            } else if (v.matches("^\\d+$")) {
                int k = i;
                while (k < len) {
                    String t = s.substring(k, k + 1);
                    if (t.equals(" ")) {
                        k++;
                    } else if (t.equals("+") || t.equals("-")) {
                        break;
                    } else if (t.matches("^\\d+$")) {
                        int m = k;
                        for (; m < len; m++) {
                            String t2 = s.substring(m, m + 1);
                            if (!t2.matches("^\\d+$")) {
                                break;
                            }
                        }
                        String value = s.substring(k, m);
                        if (stack2.isEmpty()) {
                            stack2.push(value);
                        } else {
                            String o = stack2.pop();
                            int v1 = Integer.valueOf(stack2.pop());
                            if (o.equals("*")) {
                                stack2.push(String.valueOf(v1 * Integer.valueOf(value)));
                            } else {
                                stack2.push(String.valueOf((int)(v1 / Integer.valueOf(value))));
                            }
                        }
                        k = m;
                    } else if (t.equals("*") || t.equals("/")) {
                        stack2.push(t);
                        k++;
                    }
                }
                i = k;
                int value = Integer.valueOf(stack2.pop());
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(value));
                } else {
                    String o = stack.pop();
                    int v1 = Integer.valueOf(stack.pop());
                    if (o.equals("+")) {
                        stack.push(String.valueOf(v1 + value));
                    } else {
                        stack.push(String.valueOf(v1 - value));
                    }
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
