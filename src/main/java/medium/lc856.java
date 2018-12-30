/**
 * https://leetcode.com/problems/score-of-parentheses/
 * 856. Score of Parentheses
 */
class Solution {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            String c = S.substring(i, i + 1);
            if (c.equals("(")) {
                stack.push(c);
            } else {
                String top = stack.pop();
                int val;
                if (top.equals("(")) {
                 val = 1;
                } else {
                    //数字
                    val = Integer.valueOf(top);
                    stack.pop();
                    val = val * 2; 
                }
                while (!stack.isEmpty()) {
                        if (stack.peek().equals("(")) {
                            break;
                        } else {
                            val += Integer.valueOf(stack.pop());
                        }
                    }
                    stack.push(String.valueOf(val));
            }
        }
        
        if (stack.size() == 1) {
            return Integer.valueOf(stack.pop());
        } else {
            stack.pop();
            return Integer.valueOf(stack.pop());
        }
    }
}