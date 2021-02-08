package medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/
// 1003. 检查替换后的词是否有效

public class lc1003 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == 'a' || chr == 'b') {
                deque.offerLast(chr);
            }
            else {
                if (deque.size() < 2) {
                    return false;
                }
                char b = deque.pollLast();
                char a = deque.pollLast();
                if (b != 'b' || a != 'a') {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
