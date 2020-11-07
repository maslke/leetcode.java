package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/lexicographical-numbers/
// 模拟N叉树的遍历
public class lc386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (top == 0) {
                for (int i = 9; i >= 1; i--) {
                    if (i <= n) {
                        stack.push(i);
                    }
                }
            } else {
                list.add(top);
                int m = top * 10;
                for (int i = 9; i >= 0; i--) {
                    if (m + i <= n){
                        stack.push(m + i);
                    }
                }
            }
        }


        return list;
    }

}
