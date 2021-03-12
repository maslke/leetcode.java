package medium;

import java.util.ArrayDeque;
import java.util.Deque;

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
        String[] parts = preorder.split(",");
        if (parts.length == 1 && parts[0].equals("#")) {
            return true;
        }
        boolean init = false;
        Deque<Integer> deque = new ArrayDeque<>();
        for (String p : parts) {
            if (p.equals("#")) {
                if (deque.isEmpty()) {
                    return false;
                }
                int v = deque.pollLast();
                if (v <= 0) {
                    return false;
                }
                if (v == 2) {
                    deque.offerLast(1);
                }
                else {
                    while (!deque.isEmpty()) {
                        int v2 = deque.pollLast();
                        if (v2 == 2) {
                            deque.offerLast(1);
                            break;
                        }
                    }
                }
            }
            else {
                if (init && deque.isEmpty()) {
                    return false;
                }
                init = true;
                deque.offerLast(2);
            }
        }
        return deque.isEmpty();
    }
}
