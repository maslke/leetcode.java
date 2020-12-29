package easy;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch/
// 1700. 无法吃午餐的学生数量

public class lc1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int one = 0;
        for (int s : students) {
            one = one + s;
            deque.offerLast(s);
        }
        int zero = n - one;
        int i = 0;
        while (!deque.isEmpty()) {
            if (deque.peekFirst() == sandwiches[i]) {
                i++;
                int v = deque.pollFirst();
                if (v == 1) {
                    one--;
                } else {
                    zero--;
                }
            } else {
                if (one != 0 && zero != 0) {
                    deque.offerLast(deque.pollFirst());
                } else {
                    break;
                }

            }
        }
        return deque.size();
    }
}
