package medium;

import java.util.Stack;

// https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/
// 1249. 移除无效的括号

public class lc1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] flag = new boolean[s.length()];
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
                flag[i] = true;
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    flag[i] = true;
                } else {
                    int p = stack.pop();
                    flag[p] = false;
                }
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int inx = 0; inx < s.length(); inx++) {
            if (!flag[inx]) {
                sb.append(s.charAt(inx));
            }
        }
        return sb.toString();
    }
}
