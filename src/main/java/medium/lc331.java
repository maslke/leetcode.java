package medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
// 331. 验证二叉树的前序序列化

public class lc331 {
    // 没想出来的解法
    public boolean isValidSerialization2(String preorder) {
        int slots = 1;
        String[] parts = preorder.split(",");
        for (String p : parts) {
            slots -= 1;
            if (slots < 0) {
                return false;
            }
            if (!p.equals("#")) {
                slots += 2;
            }
        }
        return slots == 0;
    }

    // 朴素办法
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        String[] parts = preorder.split(",");
        if (parts.length == 1 && parts[0].equals("#")) {
            return true;
        }
        for (int i = 0; i < parts.length; i++) {
            String p = parts[i];
            if (p.equals("#") && stack.isEmpty()) {
                return false;
            }
            if(stack.isEmpty() && i != 0) {
                return false;
            }
            if (stack.isEmpty()) {
                stack.push(p);
            } else {
                String peek = stack.peek();
                if (set.contains(peek)) {

                    stack.pop();
                    set.remove(peek);
                    if (!p.equals("#")) {
                        stack.push(p);
                    }

                } else {
                    set.add(peek);
                    if (!p.equals("#")) {
                        stack.push(p);
                    }
                }
            }

        }

        return stack.isEmpty();
    }
}
