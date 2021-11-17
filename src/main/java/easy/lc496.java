package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode-cn.com/problems/next-greater-element-i/
// 496. 下一个更大元素 I

public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int v = nums2[i];
            while (!stack.isEmpty() && stack.peek() < v) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(v, -1);
            }
            else {
                map.put(v, stack.peek());
            }
            stack.push(v);
        }


        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }
}
