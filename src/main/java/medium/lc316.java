package medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// https://leetcode-cn.com/problems/remove-duplicate-letters/
// 316. 去除重复字母

public class lc316 {
    public String removeDuplicateLetters(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']--;
            while (!set.contains(c) && !stack.isEmpty() && stack.peek() > c && chars[stack.peek() - 'a'] > 0) {
                set.remove(stack.pop());
            }
            if (!set.contains(c)) {
                stack.push(c);
                set.add(c);
            }

        }
        char[] ret = new char[stack.size()];
        int inx = ret.length - 1;
        while (!stack.isEmpty()) {
            ret[inx--] = stack.pop();
        }
        return new String(ret);
    }
}
