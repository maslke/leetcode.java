package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// https://leetcode-cn.com/problems/sliding-window-maximum/
// 239. 滑动窗口最大值

class lc239 {

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        int[] ret = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                while (queue.peekFirst() < j) {
                    queue.pollFirst();
                }
                ret[j++] = nums[queue.peekFirst()];
            }
        }
        return ret;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] ret = new int[n - k + 1];
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] < nums[i]) {
                linkedList.pollLast();
            }
            linkedList.offerLast(i);
            if (linkedList.peekFirst() == i - k) {
                linkedList.pollFirst();
            }

            if (i >= k - 1) {
                ret[i + 1 - k] = nums[linkedList.peekFirst()];
            }
        }
        return ret;
    }
}