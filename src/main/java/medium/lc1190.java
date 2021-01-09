package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1190 {
    public String reverseParentheses(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(') {
                deque.offerLast(i);
            }
            else if (c == ')') {
                int inx = deque.pollLast();
                revert(chars, inx, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == '(' || c == ')') {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private void revert(char[] chars, int begin, int end) {
        int i = begin;
        int j = end;
        while (i < j) {
            if (chars[i] == '(' || chars[i] == ')') {
                i++;
                continue;
            }
            if (chars[j] == '(' || chars[j] == ')') {
                j--;
                continue;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
