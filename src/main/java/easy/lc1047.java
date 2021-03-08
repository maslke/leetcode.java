package easy;

import java.util.Stack;

// https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
// 1047. 删除字符串中的所有相邻重复项

class lc1047 {

    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (len == 0 || sb.charAt(len - 1) != c) {
                sb.append(c);
                len++;
            } else {
                sb.deleteCharAt(len - 1);
                len--;
            }
        }

        return sb.toString();
    }

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