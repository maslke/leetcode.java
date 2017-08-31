package medium;

import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 * 385. Mini Parser
 */
public class lc385 {
    class NestedInteger {
        NestedInteger(int x) {

        }

        NestedInteger() {

        }

        void add(NestedInteger ni) {

        }

    }
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        int length = s.length();
        if (s.charAt(0) != '[') {
            NestedInteger ret = new NestedInteger(Integer.valueOf(s));
            return ret;
        }
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int i = 0;
        int positive = 1;
        while (i < length - 1) {
            String c = s.substring(i, i + 1);
            if (c.equals("[")) {
                NestedInteger ni = new NestedInteger();
                if (stack.isEmpty()) {
                    stack.push(ni);
                } else {
                    stack.peek().add(ni);
                    stack.push(ni);
                }
                i++;
            } else if (c.equals(",")) {
                i++;
            } else if (c.equals("]")) {
                stack.pop();
                i++;
            } else if (c.equals("-")) {
                positive = -1;
                i++;
            } else {
                int m = i;
                for (; m < length - 1; m++) {
                    if (!s.substring(m, m + 1).matches("\\d")) {
                        break;
                    }
                }
                String temp = s.substring(i, m);
                i = m;
                stack.peek().add(new NestedInteger(positive * Integer.valueOf(temp)));
                positive = 1;
            }
        }
        return stack.pop();
    }
}
