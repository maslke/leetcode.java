package medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode-cn.com/problems/decode-string/
// 394. 字符串解码

public class lc394 {
    public String decodeString(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        Deque<Character> deque = new ArrayDeque<Character>();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            if (c == ']') {
                Deque<Character> deque2 = new ArrayDeque<Character>();
                while (!deque.isEmpty() && deque.peekLast() != '[') {
                    deque2.offerFirst(deque.pollLast());
                }
                deque.pollLast();
                int count = 0;
                int plus = 1;
                while (!deque.isEmpty() && deque.peekLast() >= '0' && deque.peekLast() <= '9') {
                    count = plus * (deque.pollLast()  - '0') + count;
                    plus = plus * 10;
                }

                for (int inx = 0; inx < count; inx++) {
                    for (char chr : deque2) {
                        deque.offerLast(chr);
                    }
                }
            } else {
                deque.offerLast(c);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (char chr : deque) {
            sb.append(chr);
        }
        return sb.toString();
    }
}
