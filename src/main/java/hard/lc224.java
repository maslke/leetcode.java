package hard;

import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc224 {

    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            char chr = chars[i];
            if (chr == ' ') {
                i++;
                continue;
            }
            if (chr == '(') {
                stack2.push(chr);
                i++;
            }
            else if (chr == ')') {
                stack2.pop();
                if (!stack2.isEmpty()) {
                    char top = stack2.pop();
                    if (top == '+' || top == '-') {
                        int num1 = stack1.pop();
                        int num2 = stack1.pop();
                        if (top == '+') {
                            stack1.push(num1 + num2);
                        }
                        else {
                            stack1.push(num2 - num1);
                        }
                    }
                    else {
                        stack2.push(top);
                    }
                }
                i++;
            }
            else if (chr == '+' || chr == '-') {
                stack2.push(chr);
                i++;
            }
            else {
                int j = i;
                while (j < chars.length && (chars[j] >= '0' && chars[j] <= '9')) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                if (stack2.isEmpty() || stack2.peek() == '(' || stack2.peek() == ')') {
                    stack1.push(num);
                } else {
                    char top = stack2.pop();
                    int n = stack1.pop();
                    if (top == '+') {
                        stack1.push(n + num);
                    } else {
                        stack1.push(n - num);
                    }
                }
                i = j;
             }
        }
        return stack1.pop();
    }


    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
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
            }
            else if (c.equals(")")) {
                i++;
                int v1 = Integer.valueOf(stack.pop());
                stack.pop();
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    stack.push(String.valueOf(v1));
                }
                else {
                    String o = stack.pop();
                    int v2 = Integer.valueOf(stack.pop());
                    if (o.equals("+")) {
                        stack.push(String.valueOf(v1 + v2));
                    }
                    else {
                        stack.push(String.valueOf(v2 - v1));
                    }
                }
            }
            else if (c.equals("+") || c.equals("-")) {
                i++;
                stack.push(c);
            }
            else {
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
                }
                else {
                    int v1 = Integer.valueOf(op);
                    String o = stack.pop();
                    int v2 = Integer.valueOf(stack.pop());
                    if (o.equals("+")) {
                        stack.push(String.valueOf(v1 + v2));
                    }
                    else {
                        stack.push(String.valueOf(v2 - v1));
                    }
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        lc224 instance = new lc224();
        String s = "(12 - 3 + (1 +(4+5)))";
        int result = instance.calculate2(s);
        System.out.println(result);
    }
}
