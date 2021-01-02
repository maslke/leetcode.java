package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/online-stock-span/
// 901. 股票价格跨度

public class StockSpanner {

    private List<Integer> values;
    private int inx;
    private Stack<Integer> stack;

    public StockSpanner() {
        values = new ArrayList<>();
        inx = 0;
        stack = new Stack<>();
    }

    public int next(int price) {
        values.add(price);
        int left = -1;
        while (!stack.isEmpty() && values.get(stack.peek()) <= price) {
            left = stack.pop();
        }

        if (left == -1) {
            stack.push(inx++);
            return 1;
        } else {
            if (stack.isEmpty()) {
                stack.push(inx++);
                return inx;
            } else {
                int r = inx - stack.peek();
                stack.push(inx++);
                return r;
            }
        }
    }
}
