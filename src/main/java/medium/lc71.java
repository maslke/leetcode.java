package medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode-cn.com/problems/simplify-path/
// 71. 简化路径
public class lc71 {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String p : parts) {
            if (p.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            }
            else if (!p.equals(".") && !p.equals("")) {
                deque.offerLast(p);
            }
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            if (sb.length() == 0) {
                sb.append(deque.pollFirst());
            }
            else {
                sb.append("/").append(deque.pollFirst());
            }
        }
        return sb.toString();
    }

}
