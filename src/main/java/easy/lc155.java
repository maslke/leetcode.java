package easy;

import java.util.Stack;

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 */
public class lc155 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** initialize your data structure here. */
    public lc155() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
        if (!stack2.isEmpty()) {
            int min = stack2.peek();
            if (x <= min) {
                stack2.push(x);
            }
        } else {
            stack2.push(x);
        }
    }

    public void pop() {
        int top = stack1.pop();
        if (top == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
