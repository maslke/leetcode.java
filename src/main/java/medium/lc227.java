package medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode-cn.com/problems/basic-calculator-ii/
// 227. 基本计算器 II
public class lc227 {

    // a better solution
    public int calculate2(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        int length = s.length();
        boolean flag = true;
        boolean multi = true;
        char temp = '+';
        while (i < length) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                temp = c;
                i++;
            }
            else {
                int j = i;
                int v = 0;
                while (j < length && Character.isDigit(s.charAt(j))) {
                    v = 10 * v + (s.charAt(j) - '0');
                    j++;
                }

                if (temp == '+') {
                    deque.push(v);
                }
                else if (temp == '-') {
                    deque.push(-v);
                }
                else if (temp == '*') {
                    deque.push(deque.poll() * v);
                }
                else {
                    deque.push(deque.poll() / v);
                }
                i = j;
            }
        }

        int ret = 0;
        while (!deque.isEmpty()) {
            ret += deque.pollFirst();
        }
        return ret;
    }


    public int calculate(String s) {
        int i = 0;
        int j = s.length();
        char operator = '+';
        int ret = 0;
        while (i < j) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            }
            else if (c == '+' || c == '-') {
                i++;
                operator = c;
            }
            else {
                int m = i;
                while (m < j && (s.charAt(m) != '+' && s.charAt(m) != '-')) {
                    m++;
                }
                String sub = s.substring(i, m);
                Integer v;
                if (sub.contains("*") || sub.contains("/")) {
                    v = cal(sub);
                }
                else {
                    sub = sub.trim();
                    v = Integer.parseInt(sub);
                }
                if (operator == '+') {
                    ret = ret + v;
                }
                else {
                    ret = ret - v;
                }

                i = m;
            }
        }
        return ret;
    }

    private int cal(String s) {
        int ret = 1;
        int i = 0;
        boolean first = true;
        char operator = '*';
        int j = s.length();
        while (i < j) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            }
            else if (c == '*' || c == '/') {
                operator = c;
                i++;
            }
            else {
                int m = i;
                int v = 0;
                while (m < j && Character.isDigit(s.charAt(m))) {
                    v = 10 * v + (s.charAt(m) - '0');
                    m++;
                }
                i = m;
                if (first) {
                    ret = v;
                    first = false;
                }
                else {
                    ret = operator == '*' ? ret * v : ret / v;
                }
            }
        }
        return ret;
    }
}
