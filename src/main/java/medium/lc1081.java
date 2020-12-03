package medium;

// https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
// 1081. 不同字符的最小子序列

import java.util.Stack;

public class lc1081 {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && chars[stack.peek() - 'a'] > 0 && !stack.contains(c) ) {
                stack.pop();
                sb.deleteCharAt(sb.length() - 1);
            }
            if (!stack .contains(c)) {
                sb.append(c);
                stack.push(c);
            }
            chars[c - 'a']--;
        }

        return sb.toString();
    }
}
