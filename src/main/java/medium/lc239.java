package medium;

import java.util.LinkedList;

class lc239 {
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