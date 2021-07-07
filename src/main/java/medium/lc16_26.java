package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc16_26 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();
        int i = 0;
        int length = s.length();
        while (i < length) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                stack2.offerLast(ch);
                i++;
            } else {
                int j = i;
                while (j < length && isNumeric(s.charAt(j))) {
                    j++;
                }
                int v = Integer.parseInt(s.substring(i, j));
                if (!stack2.isEmpty() && (stack2.peekLast() == '*' || stack2.peekLast() == '/')) {
                    int v2 = stack.pollLast();
                    char op = stack2.pollLast();
                    if (op == '*') {
                        stack.offerLast(v2 * v);
                    } else {
                        stack.offerLast(v2 / v);
                    }
                } else {
                    stack.offerLast(v);
                }
                i = j;
            }
        }

        while (!stack2.isEmpty()) {
            char op = stack2.pollFirst();
            int v = stack.pollFirst();
            int v2 = stack.pollFirst();
            if(op == '+') {
                stack.offerFirst(v + v2);
            } else {
                stack.offerFirst(v - v2);
            }
        }
        return stack.pop();
    }

    private boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }
}
