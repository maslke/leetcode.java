package medium;

// https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
// 1438. 绝对差不超过限制的最长连续子数组

import java.util.LinkedList;

public class lc1438 {
    public int longestSubarray(int[] nums, int limit) {

        LinkedList<Integer> minQueue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();

        int left = 0;
        int right = 0;
        int len = nums.length;
        while (right < len) {
            int v = nums[right];
            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[right]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(right);

            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[right] ) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(right);
            if (nums[maxQueue.peek()] - nums[minQueue.peek()] > limit) {
                if (maxQueue.peek() <= left) {
                    maxQueue.poll();
                }
                if (minQueue.peek() <= left) {
                    minQueue.poll();
                }
                left++;
            }
            right++;
        }
        return right - left;
    }
}
