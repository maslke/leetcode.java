package easy;

import java.util.Stack;

// https://leetcode-cn.com/problems/max-stack/
// 716. 最大栈
class MaxStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** initialize your data structure here. */
    public MaxStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() <= x) {
            stack2.push(x);
        } else {
            stack2.push(stack2.peek());
        }
    }
    
    public int pop() {
        int v = stack1.pop();
        stack2.pop();
        return v;
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int peekMax() {
        return stack2.peek();
    }
    
    public int popMax() {
        int max = stack2.peek();
        Stack<Integer> temp = new Stack<>();

        while (!stack1.isEmpty()) {
            int v = stack1.pop();
            stack2.pop();
            if (v == max) {
                break;
            } else {
                temp.push(v);
            }

        }
        while (!temp.isEmpty()) {
            int v = temp.pop();
            if (stack2.isEmpty() || stack2.peek() <= v) {
                stack2.push(v);
            } else {
                stack2.push(stack2.peek());
            }
            stack1.push(v);
        }
        return max;   
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */