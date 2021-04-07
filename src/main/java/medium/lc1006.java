package medium;

// https://leetcode-cn.com/problems/clumsy-factorial/
// 1006. 笨阶乘

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1006 {
    public int clumsy(int N) {
        int ret = 0;
        int m = N;
        if (m == 1 || m == 2) {
            return m;
        }
        if (m == 3 || m == 4) {
            ret = 6;
        }
        else {
            ret = m + m / (m - 2);
        }
        m = m - 4;
        while (m >= 1) {
            if (m == 3 || m == 4) {
                ret -= 6;
            }
            else if (m == 1 || m == 2) {
                ret -= m;
            }
            else {
                ret -= m + m / (m - 2);
            }
            m = m - 4;
        }
        int n = N - 3;
        while (n >= 1) {
            ret += n;
            n = n - 4;
        }
        return ret;
    }

    public int clumsy2(int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(n);
        n--;
        int inx = 0;
        while (n > 0) {
            if (inx % 4 == 0) {
                deque.push(deque.pop() * n);
            }
            else if (inx % 4 == 1) {
                deque.push(deque.pop() / n);
            }
            else if (inx % 4 == 2) {
                deque.push(n);
            }
            else {
                deque.push(-n);
            }
            inx++;
            n--;
        }
        int ret = 0;
        while (!deque.isEmpty()) {
            ret += deque.pollFirst();
        }
        return ret;
    }
}
