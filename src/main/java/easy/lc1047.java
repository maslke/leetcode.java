package easy;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
// 1047. Remove All Adjacent Duplicates In String

class lc1047 {
    public String removeDuplicates(String S) {
        if (S.length() == 1)
            return S;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        char[] result = new char[stack.size()];
        int m = stack.size();
        while (!stack.isEmpty()) {
            result[--m] = stack.pop();
        }
        return new String(result);

    }
}